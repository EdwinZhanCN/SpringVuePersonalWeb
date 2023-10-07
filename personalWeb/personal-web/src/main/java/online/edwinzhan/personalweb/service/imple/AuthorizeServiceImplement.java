package online.edwinzhan.personalweb.service.imple;

import jakarta.annotation.Resource;
import online.edwinzhan.personalweb.entity.Account;
import online.edwinzhan.personalweb.mapper.UserMapper;
import online.edwinzhan.personalweb.service.AuthorizeService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null)
            throw new UsernameNotFoundException("the user name cannot be null");
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
    public boolean sendValidateEmail(String email, String sessionId) {
        String key = "email:" + sessionId +":" + email;
        Long expire = template.getExpire(key, TimeUnit.SECONDS);
        if (expire != null && expire > 0 && expire > 120) {
            // 这里，我们知道key存在且其TTL在0到120秒之间
            return false;
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
            return true;
        }catch (MailException e){
            e.printStackTrace();
            return false;
        }
        //if send failed, delete the value in Redis
        //When User is registering, get the value from Redis, then check if the verification code identical
    }
}
