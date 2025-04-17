package be.dungeonEcalora.rolePlayGameManagement.bll.services.dice;


import java.util.Map;

public interface DiceService {
    Map<String, int[]> rollDice(Map<String, Integer> diceCount);
}