package be.dungeonEcalora.rolePlayGameManagement.bll.services.waitingroom;

import be.dungeonEcalora.rolePlayGameManagement.api.models.user.UserDto;

import java.util.List;

public interface WaitingRoomService {
    void joinWaitingRoom(UserDto userDto);
    void leaveWaitingRoom(UserDto userDto);
    List<UserDto> getConnectedUsers();
    boolean canStartSession();
}