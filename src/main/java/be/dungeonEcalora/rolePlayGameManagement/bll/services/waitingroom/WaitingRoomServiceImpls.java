package be.dungeonEcalora.rolePlayGameManagement.bll.services.waitingroom;

import be.dungeonEcalora.rolePlayGameManagement.api.models.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class WaitingRoomServiceImpls implements WaitingRoomService {

    private final Map<Long, UserDto> usersInRoom = new ConcurrentHashMap<>();

    @Override
    public void joinWaitingRoom(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        usersInRoom.put(userDto.id(), userDto);
        log.info("User joined the waiting room: {}", userDto.pseudonym());
    }

    @Override
    public void leaveWaitingRoom(UserDto userDto) {
        if (userDto != null) {
            usersInRoom.remove(userDto.id());
            log.info("User left the waiting room: {}", userDto.pseudonym());
        }
    }

    @Override
    public List<UserDto> getConnectedUsers() {
        return new ArrayList<>(usersInRoom.values());
    }

    @Override
    public boolean canStartSession() {
        boolean hasAdmin = usersInRoom.values().stream().anyMatch(user -> "ADMIN".equalsIgnoreCase(String.valueOf(user.role())));
        boolean hasUser = usersInRoom.values().stream().anyMatch(user -> "USER".equalsIgnoreCase(String.valueOf(user.role())));
        return hasAdmin && hasUser;
    }
}
