package be.dungeonEcalora.rolePlayGameManagement.bll.services.equipment;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    List<Equipment> findAll();
    Optional<Equipment> findById(Long id);
    Equipment save(Equipment equipment);
    Equipment update(Long id, Equipment equipment);
    void deleteById(Long id);
}
