package be.dungeonEcalora.rolePlayGameManagement.api.controllers.waitingroom;

import be.dungeonEcalora.rolePlayGameManagement.api.models.user.UserDto;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.waitingroom.WaitingRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waiting-room")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WaitingRoomController {

    private final WaitingRoomService waitingRoomService;

    @PostMapping("/join")
    public ResponseEntity<Void> joinWaitingRoom(@RequestBody UserDto userDto) {
        waitingRoomService.joinWaitingRoom(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/leave")
    public ResponseEntity<Void> leaveWaitingRoom(@RequestBody UserDto userDto) {
        waitingRoomService.leaveWaitingRoom(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getConnectedUsers() {
        return ResponseEntity.ok(waitingRoomService.getConnectedUsers());
    }

    @GetMapping("/can-start")
    public ResponseEntity<Boolean> canStartSession() {
        return ResponseEntity.ok(waitingRoomService.canStartSession());
    }
}
