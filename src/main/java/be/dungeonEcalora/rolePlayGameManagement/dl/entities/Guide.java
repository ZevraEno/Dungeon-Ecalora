package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Guide {
    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private String description;
    private String contenu;
    private String origin;

    public Guide(String titre, String description, String contenu, String origin) {
        this.titre= titre;
        this.description= description;
        this.contenu= contenu;
        this.origin = origin;
    }
}