package be.dungeonEcalora.rolePlayGameManagement.api.models.security.forms;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(
        @NotBlank
        String pseudonym,
        @NotBlank
        String password
) {
}
