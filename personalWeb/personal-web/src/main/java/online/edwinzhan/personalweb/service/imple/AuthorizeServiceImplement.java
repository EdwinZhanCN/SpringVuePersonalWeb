package online.edwinzhan.personalweb.service.imple;

import jakarta.annotation.Resource;
import online.edwinzhan.personalweb.entity.auth.Account;
import online.edwinzhan.personalweb.mapper.UserMapper;
import online.edwinzhan.personalweb.service.AuthorizeService;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class AuthorizeServiceImplement implements AuthorizeService {

    @Value("${spring.mail.username}")
    String from;

    @Resource
    UserMapper mapper;

    @Resource
    MailSender mailSender;

    @Resource
    StringRedisTemplate template;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null)
            throw new UsernameNotFoundException("the username cannot be null");
        Account account = mapper.findAccountByNameOrEmail(username);
        if(account == null)
            throw new UsernameNotFoundException("The password or username incorrect");
        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles("user")
                .build();
    }

    @Override
    public String sendValidateEmail(String email, boolean isResettingPassword, String sessionId) {
        String key = isResettingPassword? "email:" + sessionId +":" + email + ":true" : ("email:" + sessionId +":" + email);
        Long expire = template.getExpire(key, TimeUnit.SECONDS);
        if (expire != null && expire > 0 && expire > 120) {
            // 这里，我们知道key存在且其TTL在0到120秒之间
            return "Request busy, please try again later";
        }
        if(mapper.findAccountByNameOrEmail(email) != null && !isResettingPassword){
            return "This email has been register by others.";
        }
        //generate verification code
        Random random = new Random();
        int code = random.nextInt(89999) + 100000;
        //send the verification code to email add
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Your Verification code");
        message.setText("Your Verification code is: " + code);
        //put the email and the verification code in Redis, 3 min, if the time left less than 2 min, user can resend again, repeat this procedure
        try{
            mailSender.send(message);
            template.opsForValue().set(key, String.valueOf(code), 3, TimeUnit.MINUTES);
            return null;
        }catch (MailException e){
            e.printStackTrace();
            return "Check if the email address is valid";
        }
        //if send failed, delete the value in Redis
        //When User is registering, get the value from Redis, then check if the verification code identical


    }
    @Override
    public String validateAndRegister(String username, String password, String email, String code, String sessionId){
        String key = "email:" + sessionId + ":" + email;
        if(Boolean.TRUE.equals(template.hasKey(key))){
            String s = template.opsForValue().get(key);
            if(s == null) return "The verification code is invalid, please request again";
            if(s.equals(code)){
                password = encoder.encode(password);
                template.delete(key);
                if(mapper.createAccount(username, password, email) > 0){
                    return null;
                }else{
                    return "Error occur, please contact administration";
                }
            }else{
                return "Please check your verification code";
            }
        }else{
            return "Please request a verification code";
        }
    }

    @Override
    public boolean emailExists(String email){
        return mapper.findAccountByNameOrEmail(email) != null;
    }

    @Override
    public String verifyCode(String email, String code, String sessionId){
        String key = "email:" + sessionId + ":" + email + ":true";
        if(Boolean.TRUE.equals(template.hasKey(key))){
            String s = template.opsForValue().get(key);
            if(s == null) return "The verification code is invalid, please request again";
            if(s.equals(code)){
                template.delete(key);
                return null;
            }else{
                return "Please check your verification code";
            }
        }else{
            return "Please request a verification code";
        }
    }

    @Override
    public boolean resetPassword(String password, String email){
        password = encoder.encode(password);
        return mapper.resetPasswordByEmail(password, email) > 0;
    }
}
