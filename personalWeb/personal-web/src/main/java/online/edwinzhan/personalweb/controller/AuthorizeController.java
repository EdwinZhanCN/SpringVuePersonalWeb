package online.edwinzhan.personalweb.controller;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Pattern;
import online.edwinzhan.personalweb.entity.RestBean;
import online.edwinzhan.personalweb.service.AuthorizeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
public class AuthorizeController {

    private final String EMAIL_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private final String username_regex = "^[a-zA-Z0-9._-]{3,15}$";
    private final String code_regex = "^[0-9]{6}$";

    @Resource
    AuthorizeService service;

    @PostMapping("/valid-email")
    public RestBean<String> validateEmail(@Pattern(regexp = EMAIL_REGEX)@RequestParam("email") String email,
                                          @RequestParam("isResettingPassword") boolean isResettingPassword,
                                          HttpSession session){
        String s = service.sendValidateEmail(email, isResettingPassword, session.getId());
        if(s == null)
            return RestBean.success("The e-mail has been sent, please check your inbox");
        else
            return RestBean.failure(400, s);
    }

    @PostMapping("/register")
    public RestBean<String> registerUser(@Pattern(regexp = username_regex) @RequestParam("username") String username,
                                         @RequestParam("password") String password,
                                         @Pattern(regexp = EMAIL_REGEX) @RequestParam("email")String email,
                                         @Pattern(regexp = code_regex) @RequestParam("code") String code,
                                         HttpSession session){
        String s = service.validateAndRegister(username, password, email, code, session.getId());
        if(s == null)
            return RestBean.success("Register Success");
        else
            return RestBean.failure(400, s);

    }

    @PostMapping("/email-verify")
    public RestBean<String> emailExists(@Pattern(regexp = EMAIL_REGEX)@RequestParam("email") String email){
        return service.emailExists(email)? RestBean.success("Email exists") : RestBean.failure(400, "Email does not exists");
    }

    @PostMapping("/email-validate-verify")
    public RestBean<String> validateVerifyOnly(@Pattern(regexp = EMAIL_REGEX)@RequestParam("email") String email,
                                               @Pattern(regexp = code_regex) @RequestParam("code") String code,
                                               HttpSession httpSession){
        String s = service.verifyCode(email, code, httpSession.getId());
        if(s == null){
            httpSession.setAttribute("reset-password", email);
            return RestBean.success();
        }else{
            return RestBean.failure(400, s);
        }
    }
    @PostMapping("/reset-password")
    public RestBean<String> resetPassword(
                                         @RequestParam("password") String password,
                                         HttpSession session){
        String email = (String) session.getAttribute("reset-password");
        if(email == null)
            return RestBean.failure(401, "Please complete the email validating");
        else if(service.resetPassword(password, email)){
            session.removeAttribute("reset-password");
            return RestBean.success("Password reset success");
        }else {
            return RestBean.failure(500, "Please contact with administrator");
        }

    }

}
