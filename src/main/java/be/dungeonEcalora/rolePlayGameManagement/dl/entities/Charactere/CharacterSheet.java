package be.dungeonEcalora.rolePlayGameManagement.dl.entities.Charactere;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CharacterSheet {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;

    @ManyToOne
    private CharacterSheetTemplate template;

    @OneToMany(mappedBy = "characterSheet", cascade = CascadeType.ALL)
    private List<FieldValue> fieldValues;
}
