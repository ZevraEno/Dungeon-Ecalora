package be.dungeonEcalora.rolePlayGameManagement.bll.services.equipment.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.equipment.EquipmentService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.EquipmentRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Equipment;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpls implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Override
    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment update(Long id, Equipment equipment) {
        Equipment existing = equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PNJ non trouvé"));
        existing.setName(equipment.getName());
        existing.setDescription(equipment.getDescription());
        existing.setDifficulty(equipment.getDifficulty());
        return equipmentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public Equipment getOne(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PNJ non trouvé"));
    }

    @Override
    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }
}