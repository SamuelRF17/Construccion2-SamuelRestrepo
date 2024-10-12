/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Guest;
import app.service.interfaces.AdminService;
import app.service.interfaces.PartnerService;

/**
 *
 * @author ACER
 */
@Getter
@Setter
@NoArgsConstructor
@Controller
public class PartnerController implements ControllerInterface{
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator; 
    @Autowired
    private AdminService adminService; 
    @Autowired
    private PartnerService partnerService; 

    private static final String MENU = "-MENU PARTNER-\ningrese la opcion que desea: \n 1. para crear un invitado. \n 2. para cerrar sesion. \n 3. para solicitar cambio a VIP \n 4. para aumentar fondos a la cuenta de socio";

    @Override
    public void session() throws Exception {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception {
        switch (option) {
            case "1": {
                this.createGuest();
                return true;
            }
            case "2": {
                System.out.println("se detiene el programa");;
                return false;
            }
            case "3": {
                this.requestVip();
                return true;
            }
            case "4": {
                this.increaseFunds();
                return true;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    private void createGuest() throws Exception {
        System.out.print("--Registro--\nIngrese el nombre de usuario del socio: ");
        String userName = Utils.getReader().next();
        userValidator.validUserName(userName);
        
        PartnerDto partnerDto = partnerService.findByUserName(userName);
        if (partnerDto == null) {
            System.out.println("Socio no encontrado.");
            return;
        }
        

        System.out.println("Ingrese el nombre del invitado: ");
        String name = Utils.getReader().next();
        personValidator.validName(name);

        System.out.println("Ingrese el ducumento del invitado: ");
        String document = Utils.getReader().next();
        personValidator.validDocument(document);

        System.out.println("Ingrese el teléfono del invitado: ");
        String celPhone = Utils.getReader().next();
        personValidator.validCelPhone(celPhone);

        System.out.println("Ingrese el nombre de usuario: ");
        String guestUserName = Utils.getReader().next();
        userValidator.validUserName(guestUserName);

        System.out.println("Ingrese la contraseña: ");
        String password = Utils.getReader().next();
        userValidator.validPassword(password);

        UserDto userDto = new UserDto();
        userDto.setUserName(guestUserName);
        userDto.setPassword(password);

        // Crear Guest y asociarlo con el Partner
        GuestDto guestDto = new GuestDto();
        guestDto.setUserId(userDto);
        guestDto.setPartnerId(partnerDto);
        guestDto.setStatus(true);

        //Guest guest = Helper.parse(guestDto);
        partnerService.saveGuest(guestDto);

        System.out.println("|---se ha creado el invitado exitosamente---|");

    }   

    //metodo para solicitar cambio a VIP
    private void requestVip() throws Exception {
        System.out.println("Ingrese el nombre de usuario: ");
        String userName = Utils.getReader().next();
        userValidator.validUserName(userName);
        System.out.println("Ingrese la contraseña: ");
        String password = Utils.getReader().next();
        userValidator.validPassword(password);
        PartnerDto partner = partnerService.findByUserName(userName);
        if (partner == null) {
            System.out.println("Socio no encontrado.");
            return;
        }

        if (!partner.getType().equals("Regular")) {
            System.out.println("El socio no es de tipo Regular.");
            return;
        }

        long countVIPs = partnerService.countVIPs();
        if (countVIPs >= 5) {
            System.out.println("No hay cupos disponibles para VIP.");
            return;
        }

        // boolean isApproved = adminService.approveVIPRequest(partner);
        // if (isApproved) {
        //     partner.setType("VIP");
        //     partnerService.save(partner);
        //     System.out.println("La solicitud ha sido aprobada y el socio ahora es VIP.");
        // } else {
        //     System.out.println("La solicitud no fue aprobada.");
        // }
    }

    //metodo para hacer un incremento de fondos a la cuenta de un socio
    private void increaseFunds() {
        System.out.println("Ingrese el nombre de usuario: ");
        String userName = Utils.getReader().next();
        PartnerDto partnerDto = partnerService.findByUserName(userName);
        if (partnerDto == null) {
            System.out.println("Socio no encontrado.");
            return;
        }
        System.out.println("Ingrese el monto a incrementar: ");
        double amount = Utils.getReader().nextDouble();

        double maxIncrease = partnerDto.getType().equals("VIP") ? 5000000 : 1000000;

        if (amount > maxIncrease) {
            System.out.println("No se puede incrementar más de " + maxIncrease + " para este tipo de socio.");
            return;
        }
        partnerDto.setAmount(partnerDto.getAmount() + amount);
        partnerService.save(partnerDto);
        System.out.println("Fondos incrementados exitosamente.");
    }
}