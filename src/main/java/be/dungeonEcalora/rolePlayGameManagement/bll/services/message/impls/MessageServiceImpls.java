package be.dungeonEcalora.rolePlayGameManagement.bll.services.message.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.message.MessageService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.MessageRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpls implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpls(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
