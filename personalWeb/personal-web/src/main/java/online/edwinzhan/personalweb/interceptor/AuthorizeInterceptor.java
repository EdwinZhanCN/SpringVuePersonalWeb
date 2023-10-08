package online.edwinzhan.personalweb.interceptor;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online.edwinzhan.personalweb.entity.user.AccountUser;
import online.edwinzhan.personalweb.mapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizeInterceptor implements HandlerInterceptor {

    @Resource
    UserMapper mapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            System.out.println("Authentication object is null!");
            return false;
        }
        User user = (User)authentication.getPrincipal();
        String username = user.getUsername();
        AccountUser accountUser = mapper.findAccountUserByNameOrEmail(username);
        request.getSession().setAttribute("accountUser", accountUser);
        return true;
    }
}
