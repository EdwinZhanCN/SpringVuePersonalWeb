package online.edwinzhan.personalweb.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizeService extends UserDetailsService {
    String sendValidateEmail(String email, boolean isResettingPassword, String sessionId);
    String validateAndRegister(String name, String password, String email, String code, String sessionId);
    boolean emailExists(String email);
    String verifyCode(String email, String code, String sessionId);
    boolean resetPassword(String password, String email);
}
