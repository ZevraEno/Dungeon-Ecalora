package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String nom;
        private String type;
        private String poid;
        private String description;
        private String protection;


        public Equipment(String nom, String type, String poid, String description, String protection) {
                this.nom = nom;
                this.type = type;
                this.poid = poid;
                this.description = description;
                this.protection = protection;
        }
    }
