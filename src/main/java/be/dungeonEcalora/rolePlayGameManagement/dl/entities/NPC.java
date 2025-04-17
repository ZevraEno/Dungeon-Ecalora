package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Gender;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "npcs")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NPC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String classe;

    @Column(nullable = false)
    private int level;

}