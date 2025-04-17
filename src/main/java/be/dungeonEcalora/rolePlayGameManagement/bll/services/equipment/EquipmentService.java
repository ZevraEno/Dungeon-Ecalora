package be.dungeonEcalora.rolePlayGameManagement.bll.services.equipment;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment create(Equipment equipment);
    Equipment update(Long id, Equipment Equipment);
    void delete(Long id);
    Equipment getOne(Long id);
    List<Equipment> getAll();
}
