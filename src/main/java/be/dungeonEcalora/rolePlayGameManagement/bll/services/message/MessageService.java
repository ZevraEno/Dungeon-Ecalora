package be.dungeonEcalora.rolePlayGameManagement.bll.services.message;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Message;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    List<Message> getAllMessages();
}