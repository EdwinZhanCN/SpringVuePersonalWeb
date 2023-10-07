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

    private final String email_regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    @Resource
    AuthorizeService service;

    @PostMapping("/valid-email")
    public RestBean<String> validateEmail(@Pattern(regexp = email_regex )@RequestParam("email") String email,
                                          HttpSession session){
        if(service.sendValidateEmail(email, session.getId()))
            return RestBean.success("The e-mail has been sent, please check your inbox");
        else
            return RestBean.failure(400, "the email is invalid, please contact administration");
    }


}
