package be.dungeonEcalora.rolePlayGameManagement.api.models.gamesession.dtos;

import java.util.List;

public class GameSessionDto {
    private Long id;
    private String sessionName;
    private List<String> usernames;
    private boolean started;
}
