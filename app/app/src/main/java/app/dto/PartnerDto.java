package app.dto;

import jakarta.persistence.Entity;
import java.security.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PartnerDto {
    private long Id;
    private UserDto userId;
    private double money;
    private String type;
    private Timestamp dateCreated;
}
