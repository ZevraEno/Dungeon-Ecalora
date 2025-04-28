package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;
    private String genre;
    private String difficulte;
    private String note;

    public Quest(String nom, String genre, String difficulte, String note) {
        this.nom = nom;
        this.genre = genre;
        this.difficulte = difficulte;
        this.note= note;
    }
}