package be.dungeonEcalora.rolePlayGameManagement.api.controllers.message;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.message.MessageService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }
}
