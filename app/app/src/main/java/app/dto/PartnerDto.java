package app.dto;

import java.security.Timestamp;

import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class PartnerDto {
    private long Id;
    private User userId;
    private double amount;
    private String type;
    private Timestamp dateCreated;
}
