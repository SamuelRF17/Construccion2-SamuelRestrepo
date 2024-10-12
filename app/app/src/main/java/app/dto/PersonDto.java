package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonDto {
    private long Id;    
    private long cedula;
    private String name;
    private long celPhone;
}
