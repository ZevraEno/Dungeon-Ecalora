package be.dungeonEcalora.rolePlayGameManagement.bll.services.gamesession.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.gamesession.GameSessionService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.GameSessionRepository;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.UserRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.GameSession;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Role;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameSessionServiceImpls implements GameSessionService {

    private final GameSessionRepository gameRepo;
    private final UserRepository userRepo;

    @Override
    public GameSession createSession(String name) {
        GameSession session = new GameSession();
        session.setSessionName(name);
        session.setStarted(false);
        return gameRepo.save(session);
    }

    @Override
    public GameSession addPlayer(Long sessionId, Long userId) {
        GameSession session = gameRepo.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        session.getPlayers().add(user);
        return gameRepo.save(session);
    }

    @Override
    public boolean canStartSession(Long sessionId) {
        GameSession session = gameRepo.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        long adminCount = session.getPlayers().stream().filter(u -> u.getRole() == Role.ADMIN).count();
        long userCount = session.getPlayers().stream().filter(u -> u.getRole() == Role.USER).count();

        return adminCount >= 1 && userCount >= 1;
    }

    @Override
    public GameSession startSession(Long sessionId) {
        if (!canStartSession(sessionId)) {
            throw new RuntimeException("Not enough players to start session.");
        }

        GameSession session = gameRepo.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        session.setStarted(true);
        return gameRepo.save(session);
    }
}
