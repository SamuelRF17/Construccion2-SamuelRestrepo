package app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "invoice_detail")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "invoiceid")
    private Invoice invoiceId; // Relación con Invoice

    @Column(name = "item")
    private int item;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private double amount;    
}
