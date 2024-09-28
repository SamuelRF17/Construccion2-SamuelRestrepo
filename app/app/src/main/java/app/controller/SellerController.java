/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.controller.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ACER
 */
public class SellerController implements ControllerInterface {
    @Autowired
    private PersonValidator personValidator;
    
    private static final String MENU = "ingrese la opcion que desea: \n 1. para . \n 2. para detener la ejecucion.";

    
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
        
    }
}
