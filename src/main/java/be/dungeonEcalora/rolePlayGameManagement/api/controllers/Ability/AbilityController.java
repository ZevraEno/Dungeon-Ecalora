package be.dungeonEcalora.rolePlayGameManagement.api.controllers.Ability;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.ability.AbilityService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Ability;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class AbilityController {

    private final AbilityService service;

    public AbilityController(AbilityService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ability> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Ability getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Ability create(@RequestBody Ability ability) {
        return service.create(ability);
    }

    @PutMapping("/{id}")
    public Ability update(@PathVariable Long id, @RequestBody Ability ability) {
        return service.update(id, ability);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
