package be.dungeonEcalora.rolePlayGameManagement.dal.initializers;

import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.UserRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.User;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Gender;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializers implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

            String password = passwordEncoder.encode("1234");

            userRepository.save(new User("admin", "admin@admin.be", password, LocalDate.now(), Gender.MALE, Role.ADMIN));
            userRepository.save(new User("Utilisateur supprimé", "delete@delete.com", password, LocalDate.now(), Gender.MALE, Role.USER));
            userRepository.save(new User("user", "user@user.be", password, LocalDate.now(), Gender.MALE, Role.USER));
            User member1 = new User("Dylan", "greywarden.dp@gmail.com", password, LocalDate.of(1996, 1, 29), Gender.MALE, Role.USER);

            List<User> members = List.of(
                    member1,
                    new User("user4", "user4@user.be", password, LocalDate.of(1995, 4, 10), Gender.FEMALE, Role.USER),
                    new User("user5", "user5@user.be", password, LocalDate.of(1998, 7, 19), Gender.MALE, Role.USER),
                    new User("user6", "user6@user.be", password, LocalDate.of(1992, 10, 30), Gender.FEMALE, Role.USER),
                    new User("user7", "user7@user.be", password, LocalDate.of(1980, 1, 5), Gender.MALE, Role.USER),
                    new User("user8", "user8@user.be", password, LocalDate.of(2002, 3, 25), Gender.FEMALE, Role.USER)
            );

            userRepository.saveAll(members);

    }
}