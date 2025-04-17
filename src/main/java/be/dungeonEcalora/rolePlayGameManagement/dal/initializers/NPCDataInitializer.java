package be.dungeonEcalora.rolePlayGameManagement.dal.initializers;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.NPC;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.NPCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NPCDataInitializer implements CommandLineRunner {

    private final NPCRepository npcRepository;

    @Override
    public void run(String... args) throws Exception {

        if (npcRepository.count() == 0) {
            npcRepository.save(NPC.builder()
                    .name("Thalor")
                    .description("Un vieux mage mystérieux vivant dans une tour isolée.")
                    .race("Elfe")
                    .classe("Magicien")
                    .role("Sage")
                    .level(12)
                    .build());

            npcRepository.save(NPC.builder()
                    .name("Bruk")
                    .description("Un guerrier orc au passé trouble.")
                    .race("Orc")
                    .classe("Barbare")
                    .role("Gardien")
                    .level(9)
                    .build());

            npcRepository.save(NPC.builder()
                    .name("Sélène")
                    .description("Une prêtresse humaine qui soigne les blessés de guerre.")
                    .race("Humaine")
                    .classe("Clerc")
                    .role("Soigneur")
                    .level(10)
                    .build());

            System.out.println("NPCs initiaux insérés !");
        }
    }
}
