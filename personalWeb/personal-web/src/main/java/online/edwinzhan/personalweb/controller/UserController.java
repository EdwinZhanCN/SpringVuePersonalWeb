package online.edwinzhan.personalweb.controller;

import online.edwinzhan.personalweb.entity.RestBean;
import online.edwinzhan.personalweb.entity.user.AccountUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/me")
    public RestBean<AccountUser> me(@SessionAttribute("accountUser") AccountUser accountUser){
        return RestBean.success(accountUser);
    }
}
