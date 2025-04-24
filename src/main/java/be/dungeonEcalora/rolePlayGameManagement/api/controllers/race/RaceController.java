package be.dungeonEcalora.rolePlayGameManagement.api.controllers.race;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.race.RaceService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Race;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public List<Race> getAllRaces() {
        return raceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Race> getRaceById(@PathVariable Long id) {
        return raceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Race createRace(@RequestBody Race race) {
        return raceService.save(race);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Race> updateRace(@PathVariable Long id, @RequestBody Race race) {
        try {
            return ResponseEntity.ok(raceService.update(id, race));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Long id) {
        raceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
