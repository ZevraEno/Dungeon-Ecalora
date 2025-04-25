package be.dungeonEcalora.rolePlayGameManagement.api.controllers.gamesession;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.gamesession.GameSessionService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.GameSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class GameSessionController {

    private final GameSessionService sessionService;

    @PostMapping
    public GameSession createSession(@RequestParam String name) {
        return sessionService.createSession(name);
    }

    @PostMapping("/{sessionId}/addPlayer/{userId}")
    public GameSession addPlayer(@PathVariable Long sessionId, @PathVariable Long userId) {
        return sessionService.addPlayer(sessionId, userId);
    }

    @GetMapping("/{sessionId}/canStart")
    public boolean canStart(@PathVariable Long sessionId) {
        return sessionService.canStartSession(sessionId);
    }

    @PostMapping("/{sessionId}/start")
    public GameSession start(@PathVariable Long sessionId) {
        return sessionService.startSession(sessionId);
    }
}
