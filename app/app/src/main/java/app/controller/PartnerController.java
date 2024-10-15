package app.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Person;
import app.service.Service;
import app.service.interfaces.AdminService;
import app.service.interfaces.PartnerService;
import app.service.interfaces.PersonService;
import app.service.interfaces.UserService;

@Getter
@Setter
@Controller
public class PartnerController implements ControllerInterface {
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private AdminService adminService;
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private UserService userService;
    @Autowired
    private Service service;
    @Autowired
    private PersonService personService;

    public PartnerController (){

    }

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
                System.out.println("se ha cerrado sesion");
                return false;
            }
            case "3": {
                this.requestVip();
                return true;
            }
            case "4": {
                this.increaseFounds();
                return true;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    private void createGuest() throws Exception {
        Person personDto = new Person();
        System.out.println("Ingrese el nombre del invitado: ");
        String name = Utils.getReader().next();
        personDto.setName(name);
        personValidator.validName(name);

        System.out.println("Ingrese el documento del invitado: ");
        String document = Utils.getReader().next();
        personDto.setCedula(Long.parseLong(document));
        personValidator.validDocument(document);
            
        System.out.println("Ingrese el teléfono del invitado: ");
        String celPhone = Utils.getReader().next();
        personDto.setCelphone(Long.parseLong(celPhone));
        personValidator.validCelPhone(celPhone);
        personDto.getId();
        personService.createPerson(personDto);
        
        System.out.println("a");
        PersonDto newPerson = this.service.createPerson(personDto);
        System.out.println("b");
        UserDto userDto = new UserDto();
        System.out.println("c");
        
        System.out.println("Ingrese el usuario:");
        String guestUserName = Utils.getReader().nextLine();
        userDto.setUserName(guestUserName);
        userValidator.validUserName(guestUserName);

        System.out.println("Ingrese la contraseña: ");
        String password = Utils.getReader().next();
        userDto.setPassword(password);
        userValidator.validPassword(password);

        PersonDto personDtoToSet = new PersonDto();
        personDtoToSet.setId(newPerson.getId());
        userDto.setPersonId(personDtoToSet);

        userDto.setRol("invitado");
        UserDto newUserDto = this.service.createUser(userDto);

        GuestDto guestDto = new GuestDto();
        guestDto.setUserId(newUserDto);
        guestDto.setPartnerId(service.getPartner());
        guestDto.setStatus(true);

        service.saveGuest(guestDto);

        System.out.println("|---se ha creado el invitado exitosamente---|");
}

    private void requestVip() throws Exception {
        PartnerDto partnerDto = service.getPartner();

        if (partnerDto.getType().equals("VIP")) {
            System.out.println("Ya eres un socio VIP");
            return;
        }
        if (!service.approveVIPRequest(partnerDto)) {
            System.out.println("No hay cupos disponibles para socios VIP");
            return;
            
        }
        
        
    }

    private void increaseFounds() throws Exception {
        PartnerDto partnerDto = service.getPartner();
    
        System.out.println("Ingrese el monto que desea aumentar a su cuenta:");
        String amount = Utils.getReader().nextLine();
        double amountToIncrease = Double.parseDouble(amount);
    
        if (amountToIncrease <= 0) {
            System.out.println("El monto debe ser mayor que cero");
            return;
        }
    
        if (partnerDto.getAmount() < amountToIncrease) {
            System.out.println("No tiene fondos suficientes para realizar el aumento");
            return;
        }
    
        partnerDto.setAmount(partnerDto.getAmount() + amountToIncrease);
        service.updatePartner(partnerDto);
    
        System.out.println("Se ha aumentado el monto de su cuenta exitosamente");
        System.out.println("Nuevo saldo: " + partnerDto.getAmount());
    }
}
