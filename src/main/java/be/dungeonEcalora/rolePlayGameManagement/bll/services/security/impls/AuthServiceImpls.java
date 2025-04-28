package be.dungeonEcalora.rolePlayGameManagement.bll.services.security.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user.PseudonymFoundException;
import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user.PseudonymNotFoundException;
import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user.UserBadCredentialsException;
import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user.UserEmailException;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.UserRepository;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.email.EmailService;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.security.AuthService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Role;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpls implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public void register(User user) throws MessagingException {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new UserEmailException(HttpStatus.CONFLICT,"Email "+user.getEmail()+" already exists");
        }
        if (userRepository.existsByPseudonym(user.getPseudonym())){
            throw new PseudonymFoundException(HttpStatus.CONFLICT, "Member with pseudonym "+user.getPseudonym()+" already exists");
        }
        String password = generateRandomPassword(12);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.Player);
        userRepository.save(user);
        Map<String, Object> variables = new HashMap<>();
        variables.put("username", user.getUsername());
        variables.put("password", password);
        emailService.sendEmail(user.getEmail(), "Nouvelle inscription", "RegisterMail", variables);

    }

    @Override
    public be.dungeonEcalora.rolePlayGameManagement.dl.entities.User login(String pseudonym, String password) {
        User user = userRepository.findByPseudonym(pseudonym).orElseThrow(
                () -> new PseudonymNotFoundException(HttpStatus.NOT_FOUND, "Pseudonym " + pseudonym + " not found")
        );
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserBadCredentialsException(HttpStatus.BAD_REQUEST, "Wrong password");
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String pseudonym) throws UsernameNotFoundException {
        return userRepository.findByPseudonym(pseudonym).orElseThrow(
                () -> new PseudonymNotFoundException(HttpStatus.NOT_FOUND, "Pseudonym " + pseudonym + " not found")
        );
    }

    public String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+=<>?";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }
}
