package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private String bonusCaracteristique;
    private String taille;
    private String vitesse;

    public Race(String nom, String description, String bonusCaracteristique, String taille, String vitesse) {
    this.nom = nom;
    this.description = description;
    this.bonusCaracteristique = bonusCaracteristique;
    this.taille = taille;
    this.vitesse = vitesse;
    }
}