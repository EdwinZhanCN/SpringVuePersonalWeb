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
@RequestMapping("/api/auth")
public class AuthorizeController {

    private final String EMAIL_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private final String username_regex = "^[a-zA-Z0-9._-]{3,15}$";
    private final String code_regex = "^[0-9]{6}$";

    @Resource
    AuthorizeService service;

    @PostMapping("/valid-email")
    public RestBean<String> validateEmail(@Pattern(regexp = EMAIL_REGEX)@RequestParam("email") String email,
                                          HttpSession session){
        String s = service.sendValidateEmail(email, session.getId());
        if(s == null)
            return RestBean.success("The e-mail has been sent, please check your inbox");
        else
            return RestBean.failure(400, "the email is invalid, please contact administration");
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



}
