package be.dungeonEcalora.rolePlayGameManagement.dl.entities;

import be.dungeonEcalora.rolePlayGameManagement.dl.BaseEntity;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Gender;
import be.dungeonEcalora.rolePlayGameManagement.dl.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"pseudonym", "email"}) @ToString
@Entity
@Table(name = "user_")
public class User extends BaseEntity<Long> implements UserDetails {

    @Column(nullable = false, unique = true, length = 50)
    private String pseudonym;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public User(String pseudonym, String email, LocalDate birthDate, Gender gender) {
        this();
        this.pseudonym = pseudonym;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public User(String pseudonym, String email, String password, LocalDate birthDate, Gender gender) {
        this(pseudonym, email, birthDate, gender);
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.toString()));
    }

    @Override
    public String getUsername() {
        return this.pseudonym;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}