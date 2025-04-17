package be.dungeonEcalora.rolePlayGameManagement.bll.services.user.userImpls;

import be.dungeonEcalora.rolePlayGameManagement.api.models.user.UserForm;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.user.UserService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.UserRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpls implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Méthode pour mettre à jour les informations d'un membre.
     *
     * @param userForm Objet contenant les nouvelles informations du membre.
     * @throws UserNotFoundException Si le membre avec cet identifiant n'est pas trouvé.
     */
    @Override
    public void update(UserForm userForm, Long memberId) {
        User memberToUpdate = userRepository.findById(memberId).orElseThrow(
                () -> new UserNotFoundException(HttpStatus.NOT_FOUND, "Member with pseudonym " + userForm.pseudonym() + " not found")
        );
        memberToUpdate.setPseudonym(userForm.pseudonym());
        memberToUpdate.setEmail(userForm.email());
        memberToUpdate.setPassword(passwordEncoder.encode(userForm.password()));
        memberToUpdate.setGender(userForm.gender());
        memberToUpdate.setBirthDate(userForm.birthDate());
        userRepository.save(memberToUpdate);
    }

    /**
     * Méthode pour supprimer un membre de la base de données.
     *
     * @param userId L'identifiant du membre à supprimer.
     * @throws UserNotFoundException Si le membre avec cet identifiant n'est pas trouvé.
     */
    @Override
    public void delete(Long userId) {
        User memberToDelete = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(HttpStatus.NOT_FOUND, "Member with id " + userId + " not found")
        );
        userRepository.delete(memberToDelete);
    }


    /**
     * Méthode pour récupérer tous les membres avec pagination.
     *
     * @param pageable Les informations de pagination pour limiter et trier les résultats.
     * @return Une page de membres correspondant aux critères de pagination.
     */
    @Override
    public Page<User> getAllMembers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long userId) {

    }

    /**
     * Méthode pour récupérer un membre par son identifiant.
     *
     * @param userId L'identifiant du membre à rechercher.
     * @return Le membre correspondant à l'identifiant.
     * @throws UserNotFoundException Si le membre avec cet identifiant n'est pas trouvé.
     */
    @Override
    public User getMemberById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(HttpStatus.NOT_FOUND, "Member with id " + userId + " not found")
        );
    }
}