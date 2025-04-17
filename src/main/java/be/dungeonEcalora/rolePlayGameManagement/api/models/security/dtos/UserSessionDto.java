package be.dungeonEcalora.rolePlayGameManagement.api.models.security.dtos;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Role;

public record UserSessionDto(
        Long id,
        Role role,
        String pseudonym
) {

    public static UserSessionDto fromUser(User user) {
        return new UserSessionDto(user.getId(),user.getRole(),user.getPseudonym());
    }

}
