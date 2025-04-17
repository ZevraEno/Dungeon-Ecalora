package be.dungeonEcalora.rolePlayGameManagement.api.models.dice.forms;

public record DiceRollForm(
        int d2,
        int d4,
        int d6,
        int d8,
        int d10,
        int d12,
        int d20,
        int d100
) {}