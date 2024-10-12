package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long Id;
    private String userName;
    private String Rol;
    private String password;
    private PersonDto personId;
}
