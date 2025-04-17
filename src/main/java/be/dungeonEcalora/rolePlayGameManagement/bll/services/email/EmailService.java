package be.dungeonEcalora.rolePlayGameManagement.bll.services.email;

import jakarta.mail.MessagingException;
import java.util.Map;

public interface EmailService {
    void sendEmail(String to, String subject, String templateName, Map<String, Object> variables) throws MessagingException;
}
