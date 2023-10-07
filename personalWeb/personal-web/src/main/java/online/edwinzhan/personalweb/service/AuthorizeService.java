package online.edwinzhan.personalweb.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizeService extends UserDetailsService {
    boolean sendValidateEmail(String email, String sessionId);
}
