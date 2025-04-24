package be.dungeonEcalora.rolePlayGameManagement.dl.entities.Charactere;

import jakarta.persistence.*;

@Entity
public class SheetField {
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    private String type;
    private String options;

    @ManyToOne
    private CharacterSheetTemplate template;
}