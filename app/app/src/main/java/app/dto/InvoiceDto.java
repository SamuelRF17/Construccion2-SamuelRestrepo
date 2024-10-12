package app.dto;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
