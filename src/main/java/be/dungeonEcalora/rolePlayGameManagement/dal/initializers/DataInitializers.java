package be.dungeonEcalora.rolePlayGameManagement.dal.initializers;

import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.*;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.*;
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
        private final RaceRepository raceRepository;
        private final QuestRepository questRepository;
        private final GuideRepository guideRepository;
        private final AbilityRepository abilityRepository;
        private final EquipmentRepository equipmentRepository;
        private final ItemRepository itemRepository;
        private final NPCRepository NpcRepository;

        @Override
        public void run(String... args) throws Exception {

                String password = passwordEncoder.encode("1234");

                userRepository.save(new User("ZevraEnoshima", "admin@admin.be", password, LocalDate.now(), Gender.MALE,
                                Role.GameMaster));
                userRepository.save(new User("Utilisateur supprimé", "delete@delete.com", password, LocalDate.now(),
                                Gender.MALE, Role.Player));
                userRepository.save(
                                new User("user", "user@user.be", password, LocalDate.now(), Gender.MALE, Role.Player));
                User member = new User("Dylan", "greywarden.dp@gmail.com", password, LocalDate.of(1996, 1, 29),
                                        Gender.MALE, Role.GameMaster);

                List<User> members = List.of(
                                member,
                                new User("user4", "user4@user.be", password, LocalDate.of(1995, 4, 10), Gender.FEMALE,
                                                Role.Player),
                                new User("user5", "user5@user.be", password, LocalDate.of(1998, 7, 19), Gender.MALE,
                                                Role.Player),
                                new User("user6", "user6@user.be", password, LocalDate.of(1992, 10, 30), Gender.FEMALE,
                                                Role.Player),
                                new User("user7", "user7@user.be", password, LocalDate.of(1980, 1, 5), Gender.MALE,
                                                Role.Player),
                                new User("user8", "user8@user.be", password, LocalDate.of(2002, 3, 25), Gender.FEMALE,
                                                Role.Player));
                userRepository.saveAll(members);

                Race humain = new Race(
                        "Humain",
                        "non",
                        "+2 Force",
                        "2m-2m30",
                        "moyenne");
                Race elfe = new Race(
                        "Elfe",
                        "oui",
                        "+2Dextérité",
                        "1m70-2m",
                        "fine");
                Race nain = new Race(
                        "Nain",
                        "non",
                        "+2Constitution",
                        "1m20-1m50",
                        "trapu");
                Race drake = new Race(
                        "Humain",
                        "non",
                        "+2Force",
                        "2m-2m30",
                        "moyenne");
                Race furry = new Race(
                        "Elfe",
                        "oui",
                        "+2Dextérité",
                        "1m70-2m",
                        "fine");
                Race lapin = new Race(
                        "Nain",
                        "non",
                        "+2Constitution",
                        "1m20-1m50",
                        "trapu");
                Race japon = new Race(
                        "Humain",
                        "non",
                        "+2Force",
                        "2m-2m30",
                        "moyenne");
                Race pomme = new Race(
                        "Elfe",
                        "oui",
                        "+2Dextérité",
                        "1m70-2m",
                        "fine");
                Race fezur = new Race(
                        "Nain",
                        "non",
                        "+2Constitution",
                        "1m20-1m50",
                        "trapu");
                Race alien = new Race(
                        "Humain",
                        "non",
                        "+2Force",
                        "2m-2m30",
                        "moyenne");
                Race weeb = new Race(
                        "Elfe",
                        "oui",
                        "+2Dextérité",
                        "1m70-2m",
                        "fine");
                Race magicien = new Race(
                        "Nain",
                        "non",
                        "+2Constitution",
                        "1m20-1m50",
                        "trapu");
                raceRepository.saveAll(List.of(humain, elfe, nain, drake, furry, lapin, japon, pomme, fezur, alien, weeb, magicien));

                Quest quest = new Quest(
                        "Humain",
                        "oui",
                        "+2Force",
                        "2m-2m30");
                Quest quest2 = new Quest(
                        "Humain",
                        "oui",
                        "+2Force",
                        "2m-2m30");
                questRepository.saveAll(List.of(quest, quest2));

                Guide guide = new Guide(
                        "oui",
                        "oui",
                        "oui",
                        "oui");
                Guide guide2 = new Guide(
                        "oui",
                        "oui",
                        "oui",
                        "oui");

                guideRepository.saveAll(List.of(guide, guide2));

                Equipment equipment = new Equipment(
                        "oui",
                        "oui",
                        "oui",
                        "oui",
                        "oui");
                Equipment equipment2 = new Equipment(
                        "oui",
                        "oui",
                        "oui",
                        "oui",
                        "oui");
                equipmentRepository.saveAll(List.of(equipment, equipment2));


        }
}