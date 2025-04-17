package be.dungeonEcalora.rolePlayGameManagement.api.controllers.quete;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.quest.QuestService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.NPC;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Quest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quests")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class QuestController {

    private final QuestService questService;

    @Operation(summary = "create a Quest")
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<Quest> create(@Valid @RequestBody Quest quest) {
        return ResponseEntity.ok(questService.create(quest));
    }

    @Operation(summary = "update a Quest")
    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    public ResponseEntity<Quest> update(@PathVariable Long id, @Valid @RequestBody Quest quest) {
        return ResponseEntity.ok(questService.update(id, quest));
    }

    @Operation(summary = "delete a Quest")
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        questService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "obtain a Quest")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<Quest> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(questService.getOne(id));
    }

    @Operation(summary = "obtain all Quest")
    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<List<Quest>> getAll() {
        return ResponseEntity.ok(questService.getAll());
    }
}
