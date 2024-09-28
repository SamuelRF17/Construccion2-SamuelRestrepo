package app.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long Id;
    private String userName;
    private String Rol = "Socio";
    private String password;
    private PersonDto personId;
}
