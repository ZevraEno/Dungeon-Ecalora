package be.dungeonEcalora.rolePlayGameManagement.api.controllers.Equipment;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.equipment.EquipmentService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Equipment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin(origins = "*")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<Equipment> getAll() {
        return equipmentService.getAll();
    }

    @GetMapping("/{id}")
    public Equipment getOne(@PathVariable Long id) {
        return equipmentService.getOne(id);
    }

    @PostMapping
    public Equipment create(@RequestBody Equipment equipment) {
        return equipmentService.create(equipment);
    }

    @PutMapping("/update")
    public Equipment update(@PathVariable Long id, @RequestBody Equipment equipment) {
        return equipmentService.update(id, equipment);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        equipmentService.delete(id);
    }
}
