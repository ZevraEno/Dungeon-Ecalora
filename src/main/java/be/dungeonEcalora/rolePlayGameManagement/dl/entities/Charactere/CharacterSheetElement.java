package be.dungeonEcalora.rolePlayGameManagement.dl.entities.Charactere;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacterSheetElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    @Enumerated(EnumType.STRING)
    private FieldType fieldType;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private CharacterSheetTemplate template;

    public enum FieldType {
        TEXT, NUMBER, TEXTAREA, DROPDOWN
    }
}
