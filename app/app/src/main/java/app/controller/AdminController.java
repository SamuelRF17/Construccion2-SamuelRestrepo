package app.controller;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Person;
import app.service.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@NoArgsConstructor
@Controller
public class AdminController implements ControllerInterface {
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private Service service;
    private static final String MENU = "Ingrese la opcion que desea \n 1. Para registrar y crear usuario \n 2. Para crear invitado \n 3. Para cerrar sesion \n";


    @Override
	public void session() throws Exception {
        boolean session = true;
        while (session) {
                session = menu();
        } 
	}

    private boolean menu() {
        try {
            System.out.println("bienvenido ");
            System.out.print(MENU);
            String option = Utils.getReader().next();
            System.out.println(option);
            return options(option);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception{
        switch(option) {
            case "1": 
                this.createUser();
                return true;
            case "2": 
                return true;
            case "3": 
                System.out.println("se ha cerrado sesion");
                return false;
            default: 
                System.out.println("ingrese una opcion valida");
                return true;
        }
    }

    public void createUser() throws Exception {
        System.out.print("--Registro--\nIngrese nombre completo: ");
        String name = Utils.getReader().next();
        personValidator.validName(name);
        System.out.print("Ingrese cedula: ");
        String document = Utils.getReader().next();
        personValidator.validDocument(document);	
        System.out.print("Ingrese numero de telefono: ");
        String celPhone = Utils.getReader().next();
        personValidator.validCelPhone(celPhone);
        System.out.print("--Crear usuario--\nIngrese nombre de usuario: ");
        String userName = Utils.getReader().next();
        userValidator.validUserName(userName);
        System.out.print("ingrese la contrasena: ");
        String password = Utils.getReader().next();
        userValidator.validPassword(password);
        Person personDto = new Person();
        personDto.setName(name);
        personDto.setCedula(Long.parseLong(document));
        personDto.setCelphone(Long.parseLong(celPhone));
        PersonDto newPersonDto = this.service.createPerson(personDto);

        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassword(password);
        userDto.setPersonId(Helper.parse(personDto));
        userDto.setPersonId(newPersonDto);
        userDto.setRol("socio");
        UserDto newUserDto = this.service.createUser(userDto);
        
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setUserId(newUserDto);
        partnerDto.setAmount(50000);
        partnerDto.setType("standard"); 
        this.service.save(partnerDto);

        System.out.println("|---se ha creado el usuario exitosamente---|");
    }   
}
