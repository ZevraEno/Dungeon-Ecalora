package be.dungeonEcalora.rolePlayGameManagement.bll.services.dice.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.dice.DiceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class DiceServiceImpl implements DiceService {

    private final Random random = new Random();

    @Override
    public Map<String, int[]> rollDice(Map<String, Integer> diceCount) {
        Map<String, int[]> results = new HashMap<>();

        for (Map.Entry<String, Integer> entry : diceCount.entrySet()) {
            String type = entry.getKey();
            int count = entry.getValue();

            try {
                int faces = Integer.parseInt(type.substring(1));
                int[] rolls = new int[count];
                for (int i = 0; i < count; i++) {
                    rolls[i] = random.nextInt(faces) + 1;
                }
                results.put(type, rolls);
            } catch (NumberFormatException e) {
            }
        }

        return results;
    }
}
