package be.dungeonEcalora.rolePlayGameManagement.bll.services.equipment.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.equipment.EquipmentService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.EquipmentRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Equipment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpls implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpls(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> findById(Long id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public Equipment save(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment update(Long id, Equipment equipment) {
        return equipmentRepository.findById(id).map(existing -> {
            existing.setNom(equipment.getNom());
            existing.setType(equipment.getType());
            existing.setPoid(equipment.getPoid());
            existing.setDescription(equipment.getDescription());
            existing.setProtection(equipment.getProtection());
            return equipmentRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("equipment not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        equipmentRepository.deleteById(id);
    }
}