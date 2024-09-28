package app.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class InvoiceDto {
    private long invoiceId;
    private PersonDto personId;
    private PartnerDto partnerId;
    private Date dateCreated;
    private double amount;
    private Boolean status;
}
