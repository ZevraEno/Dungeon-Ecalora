package be.dungeonEcalora.rolePlayGameManagement.api.models.user;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

public record UserForm(
        @NotBlank @Size(max = 50)
        String pseudonym,
        @NotBlank @Size(max = 150)
        String email,
        @NotNull
        String password,
        @NotNull @Past
        LocalDate birthDate,
        @NotNull
        Gender gender,
        @NotNull @Range(min = 0, max = 3000)
        int elo
){
    public User toMember(){
        return new User(
                this.pseudonym,
                this.email,
                this.password,
                this.birthDate,
                this.gender
        );
    }
}
