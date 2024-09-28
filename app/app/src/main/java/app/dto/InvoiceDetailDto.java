package app.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class InvoiceDetailDto {
    private long Id;
    private InvoiceDto invoiceId;
    private int item;
    private String description;
    private double amount;

}
