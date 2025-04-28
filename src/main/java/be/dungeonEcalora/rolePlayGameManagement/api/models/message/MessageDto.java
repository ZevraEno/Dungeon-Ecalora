package be.dungeonEcalora.rolePlayGameManagement.api.models.message;

public class MessageDto {
    private String sender;
    private String receiver; // null = message public
    private String content;

    public MessageDto(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }
}
