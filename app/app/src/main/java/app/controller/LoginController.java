/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import java.util.HashMap;
import java.util.Map;

import app.controller.validator.UserValidator;
import app.dao.UserDaoImplementation;
import app.dto.UserDto;
import app.service.Service;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ACER
 */
@Getter
@Setter
@Controller
public class LoginController implements ControllerInterface{
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private Service service;
    @Autowired
    private UserDaoImplementation userDaoImplementation;
    private static final String MENU = "-MENU PRICIPAL--\ningrese la opcion que desea: \n 1. para iniciar sesion. \n 2. para detener la ejecucion.";
    private Map<String, ControllerInterface> roles;

    public LoginController(AdminController adminController, PartnerController partnerController, GuestController guestController){
        this.roles = new HashMap<String, ControllerInterface>();
        roles.put("admin", adminController);
        roles.put("invitado",guestController );
        roles.put("socio", partnerController);
    }

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
                this.login();
                return true;
            }
            case "2": {
                System.out.println("se detiene el programa");;
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    private void login() throws Exception {
        System.out.println("Ingrese el usuario:");
        String userName = Utils.getReader().nextLine();
        userValidator.validUserName(userName);
        System.out.println("Ingrese la contraseña:");
        String password = Utils.getReader().nextLine(); 
        userValidator.validPassword(password);  
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassword(password);
        this.service.login(userDto);
        if(service.getUser().getRol() == null){
            throw new Exception("el usuario no esta registrado");   
        }
        System.out.println("--inicio de sesion completada--");
        String rol = service.getUser().getRol();
        ControllerInterface controller = roles.get(rol);
        if (controller != null) {
            controller.session();
        } else {
            throw new Exception("Rol no reconocido");
        }
    }
    
}
