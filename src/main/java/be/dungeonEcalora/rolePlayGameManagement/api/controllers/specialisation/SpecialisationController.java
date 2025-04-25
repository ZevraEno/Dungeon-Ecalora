package be.dungeonEcalora.rolePlayGameManagement.api.controllers.specialisation;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.specialisation.SpecialisationService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Specialisation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialisation")
public class SpecialisationController {

    private final SpecialisationService specialisationService;

    public SpecialisationController(SpecialisationService specialisationService) {
        this.specialisationService = specialisationService;
    }

    @GetMapping
    public List<Specialisation> getAllClasses() {
        return specialisationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialisation> getClasseById(@PathVariable Long id) {
        return specialisationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Specialisation createClasse(@RequestBody Specialisation specialisation) {
        return specialisationService.save(specialisation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialisation> updateClasse(@PathVariable Long id, @RequestBody Specialisation classe) {
        try {
            return ResponseEntity.ok(specialisationService.update(id, classe));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Long id) {
        specialisationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
