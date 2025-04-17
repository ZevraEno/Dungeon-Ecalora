package be.dungeonEcalora.rolePlayGameManagement.bll.services.user;

import be.dungeonEcalora.rolePlayGameManagement.api.models.user.UserForm;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void update(UserForm userForm, Long userId);
    void delete(Long userId);
    Page<User> getAllMembers(Pageable pageable);
    void deleteById(Long userId);
    User getMemberById(Long userId);
}
