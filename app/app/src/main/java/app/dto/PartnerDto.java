package app.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class PartnerDto {
    private long Id;
    private UserDto userId;
    private double amount;
    private String type;
    private Date dateCreated;
}
