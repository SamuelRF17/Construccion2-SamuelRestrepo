/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

// import app.model.Partner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ESTUDIANTES
 */
@NoArgsConstructor
@Getter
@Setter
public class GuestDto {
    private long Id;
    private UserDto userId;  
    private PartnerDto partnerId;
    private Boolean status;
}
