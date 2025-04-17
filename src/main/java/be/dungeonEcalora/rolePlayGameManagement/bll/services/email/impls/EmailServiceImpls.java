package be.dungeonEcalora.rolePlayGameManagement.bll.services.email.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.email.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailServiceImpls implements EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    /**
     * Méthode pour envoyer un email avec un contenu HTML généré à partir d'un template.
     *
     * @param to L'adresse email du destinataire
     * @param subject L'objet de l'email
     * @param templateName Le nom du template Thymeleaf à utiliser
     * @param variables Les variables à injecter dans le template
     * @throws MessagingException Si une erreur survient lors de l'envoi de l'email
     */
    public void sendEmail(String to, String subject, String templateName, Map<String, Object> variables) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        Context context = new Context();
        context.setVariables(variables);
        String html = templateEngine.process(templateName, context);

        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(html, true);
        mimeMessageHelper.setFrom("loschicospollos@gmail.com");

        mailSender.send(mimeMessage);

    }
}
