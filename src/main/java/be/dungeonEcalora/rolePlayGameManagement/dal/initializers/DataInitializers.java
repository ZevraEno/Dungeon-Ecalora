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

                // Création des races
                Race humain = new Race(
                        "Humain",
                        "Non",
                        "+2 Force",
                        "2m-2m30",
                        "Race moyenne");

                Race elfe = new Race(
                        "Elfe",
                        "Oui",
                        "+2 Dextérité",
                        "1m70-2m",
                        "Race fine");

                Race nain = new Race(
                        "Nain",
                        "Non",
                        "+2 Constitution",
                        "1m20-1m50",
                        "Race trapue");

                Race drake = new Race(
                        "Drake",
                        "Non",
                        "+2 Force",
                        "2m-2m30",
                        "Race musclée");

                Race furry = new Race(
                        "Furry",
                        "Oui",
                        "+2 Dextérité",
                        "1m60-2m",
                        "Race agile");

                Race lapin = new Race(
                        "Lapin",
                        "Non",
                        "+2 Agilité",
                        "0m80-1m20",
                        "Race petite");

                Race japon = new Race(
                        "Japonais",
                        "Non",
                        "+2 Intelligence",
                        "1m60-1m80",
                        "Race élancée");

                Race pomme = new Race(
                        "Pomme",
                        "Oui",
                        "+2 Charisme",
                        "1m50-1m80",
                        "Race fruitée");

                Race fezur = new Race(
                        "Fezur",
                        "Non",
                        "+2 Endurance",
                        "1m60-2m",
                        "Race robuste");

                Race alien = new Race(
                        "Alien",
                        "Non",
                        "+2 Force",
                        "2m-3m",
                        "Race extraterrestre");

                Race weeb = new Race(
                        "Weeb",
                        "Oui",
                        "+2 Agilité",
                        "1m60-1m80",
                        "Race fanatique");

                Race magicien = new Race(
                        "Magicien",
                        "Non",
                        "+2 Intelligence",
                        "1m70-2m",
                        "Race intellectuelle");

                raceRepository.saveAll(List.of(
                        humain, elfe, nain, drake, furry, lapin, japon, pomme, fezur, alien, weeb, magicien));

                Quest quest1 = new Quest(
                        "Quête de la Forêt Sombre",
                        "Disponible",
                        "+2 Force",
                        "2m-2m30");

                Quest quest2 = new Quest(
                        "Quête de la Tour du Magicien",
                        "Disponible",
                        "+2 Intelligence",
                        "1m70-2m");

                Quest quest3 = new Quest(
                        "Quête de la Caverne des Nains",
                        "Non disponible",
                        "+2 Constitution",
                        "1m20-1m50");

                Quest quest4 = new Quest(
                        "Quête des Artefacts Mystiques",
                        "Disponible",
                        "+2 Dextérité",
                        "1m60-2m");

                questRepository.saveAll(List.of(quest1, quest2, quest3, quest4));

                Guide guide1 = new Guide(
                        "Conseils pour débutants",
                        "Stratégies avancées",
                        "Plan de campagne",
                        "Règles détaillées");

                Guide guide2 = new Guide(
                        "Conseils pour débutants",
                        "Stratégies basiques",
                        "Plan de campagne",
                        "Règles de base");

                Guide guide3 = new Guide(
                        "Conseils pour débutants",
                        "Stratégies avancées",
                        "Plan de campagne",
                        "Règles détaillées");

                guideRepository.saveAll(List.of(guide1, guide2, guide3));

                Equipment equipment1 = new Equipment(
                        "Épée en fer",
                        "1 kg",
                        "Moyenne portée",
                        "Bonne qualité",
                        "Requiert une force de 5");

                Equipment equipment2 = new Equipment(
                        "Bottes magiques",
                        "500g",
                        "Mobilité accrue",
                        "Qualité supérieure",
                        "Améliore la vitesse de déplacement");

                Equipment equipment3 = new Equipment(
                        "Bouclier de titan",
                        "10 kg",
                        "Protection maximale",
                        "Excellente qualité",
                        "Requiert une constitution de 10");

                Equipment equipment4 = new Equipment(
                        "Amulette magique",
                        "200g",
                        "Pouvoir magique",
                        "Rare",
                        "Accroît la résistance magique");

                equipmentRepository.saveAll(List.of(equipment1, equipment2, equipment3, equipment4));

        }
}