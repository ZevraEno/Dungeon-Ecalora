package be.dungeonEcalora.rolePlayGameManagement.api.controllers.guide;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.guide.GuideService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Guide;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
@CrossOrigin(origins = "*")
public class GuideController {
    private final GuideService service;

    public GuideController(GuideService service) {
        this.service = service;
    }

    @GetMapping
    public List<Guide> getAllGuides() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guide> getGuideById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Guide> createGuide(@RequestBody Guide guide) {
        Guide saved = service.save(guide);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guide> updateGuide(@PathVariable Long id, @RequestBody Guide guide) {
        return service.findById(id).map(existing -> {
            existing.setTitre(guide.getTitre());
            existing.setDescription(guide.getDescription());
            existing.setContenu(guide.getContenu());
            existing.setAuteur(guide.getAuteur());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
