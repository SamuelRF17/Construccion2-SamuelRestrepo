package app.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PersonDto {
    private long Id;    
    private long cedula;
    private String name;
    private String celPhone;
}
