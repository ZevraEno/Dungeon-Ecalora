package be.dungeonEcalora.rolePlayGameManagement.api.models.user;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Gender;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Role;

import java.time.LocalDate;

public record UserDto(
        Long id,
        String pseudonym,
        String email,
        LocalDate birthDate,
        Gender gender,
        Role role
) {

    public static UserDto fromUser(User user) {
        return new UserDto(
                user.getId(),
                user.getPseudonym(),
                user.getEmail(),
                user.getBirthDate(),
                user.getGender(),
                user.getRole()
        );
    }
}
