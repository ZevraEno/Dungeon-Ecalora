package be.dungeonEcalora.rolePlayGameManagement.bll.services.security;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import jakarta.mail.MessagingException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    void register(User user) throws MessagingException;
    User login(String pseudonym, String password);
}
