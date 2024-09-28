/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ESTUDIANTES
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name= "invoicedetail")
public class Invoice {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceId;
    @Column(name = "personid")
    private Person personId;
    @ManyToOne
    @JoinColumn(name="partnerid")
    private Partner partnerId;
    @Column(name = "creationdate")
    private Date dateCreated;
    @Column(name = "amount")
    private double amount;
    @Column(name = "status")
    private Boolean status;
}
