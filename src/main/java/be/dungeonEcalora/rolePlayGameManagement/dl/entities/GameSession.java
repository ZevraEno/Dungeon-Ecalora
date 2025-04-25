package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "gamesession_")
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionName;

    @ManyToMany
    private List<User> players = new ArrayList<>();

    private boolean started;
}
