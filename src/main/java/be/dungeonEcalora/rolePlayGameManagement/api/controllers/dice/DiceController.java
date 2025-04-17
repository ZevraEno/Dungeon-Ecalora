package be.dungeonEcalora.rolePlayGameManagement.api.controllers.dice;

import be.dungeonEcalora.rolePlayGameManagement.api.models.dice.forms.DiceRollForm;
import be.dungeonEcalora.rolePlayGameManagement.api.models.dice.dtos.DiceResultDto;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.dice.DiceService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dice")
@CrossOrigin(origins = "*")
public class DiceController {

    private final DiceService diceService;

    public DiceController(DiceService diceService) {
        this.diceService = diceService;
    }

    @Operation(summary = "gestion des dés")
    @PostMapping("/roll")
    public DiceResultDto rollDice(@RequestBody DiceRollForm form) {
        Map<String, Integer> diceMap = new HashMap<>();
        if (form.d2() > 0) diceMap.put("d2", form.d2());
        if (form.d4() > 0) diceMap.put("d4", form.d4());
        if (form.d6() > 0) diceMap.put("d6", form.d6());
        if (form.d8() > 0) diceMap.put("d8", form.d8());
        if (form.d10() > 0) diceMap.put("d10", form.d10());
        if (form.d12() > 0) diceMap.put("d12", form.d12());
        if (form.d20() > 0) diceMap.put("d20", form.d20());
        if (form.d100() > 0) diceMap.put("d100", form.d100());

        var result = diceService.rollDice(diceMap);
        return new DiceResultDto(result);
    }
}