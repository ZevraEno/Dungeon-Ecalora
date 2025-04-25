package be.dungeonEcalora.rolePlayGameManagement.bll.services.gamesession;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.GameSession;

public interface GameSessionService {
    GameSession createSession(String name);
    GameSession addPlayer(Long sessionId, Long userId);
    boolean canStartSession(Long sessionId);
    GameSession startSession(Long sessionId);
}
