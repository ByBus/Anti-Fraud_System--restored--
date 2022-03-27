package antifraud.model;

import antifraud.auth.Role;
import antifraud.validation.RoleCorrect;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class ChangeRoleDTO {
    @NotEmpty
    private String username;
    @RoleCorrect(enumClazz = Role.class, message = "Role incorrect")
    private String role;
}
