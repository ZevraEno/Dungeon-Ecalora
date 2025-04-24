package be.dungeonEcalora.rolePlayGameManagement.dl.entities.Charactere;

import jakarta.persistence.*;

@Entity
public class FieldValue {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CharacterSheet characterSheet;

    @ManyToOne
    private SheetField field;

    private String value;
}
