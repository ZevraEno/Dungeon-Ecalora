package be.dungeonEcalora.rolePlayGameManagement.api.models.charactere.dtos;

import java.util.Map;

public class CharacterSheetDataDto {
    private Long id;
    private Long templateId;
    private Long userId;
    private Map<String, String> values;

}
