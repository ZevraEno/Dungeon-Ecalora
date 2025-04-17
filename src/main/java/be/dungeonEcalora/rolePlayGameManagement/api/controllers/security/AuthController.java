package be.dungeonEcalora.rolePlayGameManagement.api.controllers.security;

import be.dungeonEcalora.rolePlayGameManagement.api.models.security.dtos.UserSessionDto;
import be.dungeonEcalora.rolePlayGameManagement.api.models.security.dtos.UserTokenDto;
import be.dungeonEcalora.rolePlayGameManagement.api.models.security.forms.LoginForm;
import be.dungeonEcalora.rolePlayGameManagement.api.models.security.forms.RegisterForm;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.security.AuthService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.il.utils.jwt.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentification")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @Operation(summary = "Inscription")
    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid @RequestBody RegisterForm form
    ) throws MessagingException {
        authService.register(form.toMember());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Connexion")
    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<UserTokenDto> login(
            @Valid @RequestBody LoginForm form
    ) {
        User user = authService.login(form.pseudonym(), form.password());
        UserSessionDto userDTO = UserSessionDto.fromUser(user);
        String token = jwtUtil.generateToken(user);
        UserTokenDto userTokenDto = new UserTokenDto(userDTO, token);
        return ResponseEntity.ok(userTokenDto);
    }
}