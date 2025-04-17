package be.dungeonEcalora.rolePlayGameManagement.api.models.dice.dtos;

import java.util.Map;

public record DiceResultDto(
        Map<String, int[]> results
) {}