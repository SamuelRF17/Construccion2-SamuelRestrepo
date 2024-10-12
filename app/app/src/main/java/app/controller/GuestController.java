/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ACER
 */
@Getter
@Setter
@NoArgsConstructor
@Controller
public class GuestController implements ControllerInterface{
    
    private static final String MENU = "-MENU INVITADO-\ningrese la opcion que desea: \n 1. para iniciar sesion. \n 2. para volver.";


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
               // this.();
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

    

}
