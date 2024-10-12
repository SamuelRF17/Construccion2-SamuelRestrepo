package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
