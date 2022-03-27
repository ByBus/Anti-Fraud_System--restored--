package antifraud.persistance;

import antifraud.auth.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isLocked;
}
