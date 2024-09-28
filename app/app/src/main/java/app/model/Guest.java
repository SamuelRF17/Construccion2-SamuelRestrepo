/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
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
public class Guest {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "userid")
    private String userId;  
    @Column(name = "partnerid")
    private Partner partnerId;
    @Column(name = "status")
    private Boolean status;
}
