package be.dungeonEcalora.rolePlayGameManagement.bll.services.ItemService.ItemServiceImpls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.ItemService.ItemService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.ItemRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Items;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Items> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Items getById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public Items create(Items item) {
        return itemRepository.save(item);
    }

    @Override
    public Items update(Long id, Items updatedItem) {
        Items item = getById(id);
        item.setName(updatedItem.getName());
        item.setType(updatedItem.getType());
        item.setDescription(updatedItem.getDescription());
        item.setValue(updatedItem.getValue());
        return itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
