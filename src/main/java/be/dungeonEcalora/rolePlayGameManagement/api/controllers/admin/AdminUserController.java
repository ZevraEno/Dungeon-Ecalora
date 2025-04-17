package be.dungeonEcalora.rolePlayGameManagement.api.controllers.admin;

import be.dungeonEcalora.rolePlayGameManagement.api.models.user.UserDto;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Administrator - Gestion des user")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/user")
@CrossOrigin(origins = "*")
public class AdminUserController {

    private final UserService userService;

    @Operation(summary = "Renvoie les membres par page (ADMIN)")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<Page<UserDto>> getAllUsersByAdmin(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    )
    {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserDto> user = userService.getAllMembers(pageable).map(UserDto::fromUser);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Suppression d'un compte (ADMIN)")
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{userId}/delete")
    public ResponseEntity<Void> deleteUserById(
            @PathVariable Long userId){
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}
