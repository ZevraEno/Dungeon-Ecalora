package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ability")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String description;
    private String levelRequirement;

}
