package online.edwinzhan.personalweb.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizeService extends UserDetailsService {
    String sendValidateEmail(String email, String sessionId);
    String validateAndRegister(String name, String password, String email, String code, String sessionId);
}
