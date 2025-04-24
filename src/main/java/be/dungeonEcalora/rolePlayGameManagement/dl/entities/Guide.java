package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "guide")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;

    @Lob
    private String contenu;

    private String auteur;
    private LocalDate datePublication;

}