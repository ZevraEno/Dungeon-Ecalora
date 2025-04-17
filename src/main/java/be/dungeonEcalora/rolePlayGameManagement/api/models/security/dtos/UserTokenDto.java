package be.dungeonEcalora.rolePlayGameManagement.api.models.security.dtos;

public record UserTokenDto(
        UserSessionDto user,
        String token
) {
}
