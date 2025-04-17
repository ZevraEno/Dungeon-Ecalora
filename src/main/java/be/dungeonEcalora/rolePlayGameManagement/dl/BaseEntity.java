package be.dungeonEcalora.rolePlayGameManagement.dl;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EqualsAndHashCode @ToString
@MappedSuperclass
public abstract class BaseEntity <T>{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    public BaseEntity(T id) {
        this.id = id;
    }

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;
}
