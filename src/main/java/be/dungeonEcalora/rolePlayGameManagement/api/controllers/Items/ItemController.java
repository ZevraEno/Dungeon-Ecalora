package be.dungeonEcalora.rolePlayGameManagement.api.controllers.Items;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Items;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.ItemService.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Items> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public Items getById(@PathVariable Long id) {
        return itemService.getById(id);
    }

    @PostMapping
    public Items create(@RequestBody Items item) {
        return itemService.create(item);
    }

    @PutMapping("/{id}")
    public Items update(@PathVariable Long id, @RequestBody Items item) {
        return itemService.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }
}
