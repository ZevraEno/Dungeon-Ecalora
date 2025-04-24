package be.dungeonEcalora.rolePlayGameManagement.dl.entities.Charactere;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacterSheetFilled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Ou relation vers User si tu veux lier plus fort

    @ManyToOne
    @JoinColumn(name = "template_id")
    private CharacterSheetTemplate template;

    @OneToMany(mappedBy = "filledSheet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterSheetValue> values;
}
