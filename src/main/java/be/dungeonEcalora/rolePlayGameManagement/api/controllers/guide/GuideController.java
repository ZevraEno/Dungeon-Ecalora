package be.dungeonEcalora.rolePlayGameManagement.api.controllers.guide;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.guide.GuideService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Guide;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
@CrossOrigin(origins = "*")
public class GuideController {
    private final GuideService guideService;

    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping
    public List<Guide> getAllGuide() {
        return guideService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guide> getGuideById(@PathVariable Long id) {
        return guideService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Guide createGuide(@RequestBody Guide guide) {
        return guideService.save(guide);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guide> updateGuide(@PathVariable Long id, @RequestBody Guide guide) {
        try {
            return ResponseEntity.ok(guideService.update(id, guide));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable Long id) {
        guideService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
