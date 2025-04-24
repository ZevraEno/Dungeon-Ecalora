package be.dungeonEcalora.rolePlayGameManagement.bll.services.ItemService;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Items;

import java.util.List;

public interface ItemService {
    List<Items> getAll();
    Items getById(Long id);
    Items create(Items item);
    Items update(Long id, Items item);
    void delete(Long id);
}
