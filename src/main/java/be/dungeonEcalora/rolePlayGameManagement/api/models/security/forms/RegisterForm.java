package be.dungeonEcalora.rolePlayGameManagement.api.models.security.forms;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record RegisterForm(
        @NotBlank @Size(max = 50)
        String pseudonym,
        @NotBlank @Size(max = 150)
        String email,
        @NotNull
        LocalDate birthDate,
        @NotNull
        Gender gender

) {

    public User toMember() {
        return new User(
                this.pseudonym,
                this.email,
                this.birthDate,
                this.gender

        );
    }
}