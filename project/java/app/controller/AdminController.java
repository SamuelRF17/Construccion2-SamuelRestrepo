package project.java.app.controller;
import java.security.Provider.Service;

import project.java.app.DTO.UserDto;
import project.java.app.controller.validator.ControllerInterface;
import project.java.app.controller.validator.PersonValidator;
import project.java.app.controller.validator.UserValidator;
import project.java.app.service.*;

public class AdminController implements ControllerInterface {
    private PersonValidator personValidator;
    private UserValidator userValidator;
	// private AdminService service;

	private static final String MENU = "ingrese la opcion que desea \n 1.para crear usuario \n 2. para crear vendedor \n 3. para cerrar sesion \n";


    public AdminController() {
        personValidator = new PersonValidator();
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
			System.out.println("bienvenido ");
			System.out.print(MENU);
			String option = Utils.getReader().nextLine();
			return options(option);

		} catch (
		Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
    }

    private boolean options(String option) throws Exception{
		switch (option) {
		case "1": {
			this.createUser();
			return true;
		}
		case "2": {
			// this.createSeller();
			return true;
		}
		case "3": {
			System.out.println("se ha cerrado sesion");
			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}

    public void createUser() throws Exception {
        System.out.println("ingrese el nombre del usuario");
		String name = Utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("ingrese la cedula del veterinario");
		long document = personValidator.validDocument(Utils.getReader().nextLine());
		System.out.println("ingrese el nombre de usuario del veterinario");
		String userName = Utils.getReader().nextLine();
		userValidator.validUserName(userName);
		System.out.println("ingrese la contraseña del veterinario");
		String password = Utils.getReader().nextLine();
		userValidator.validPassword(password);
		PersonDto personDto = new PersonDto();
		personDto.setName(name);
		personDto.setDocument(document);
		personDto.setAge(age);
		UserDto userDto = new UserDto();
		userDto.setPersonid(personDto);
		userDto.setUserName(userName);
		userDto.setPassword(password);
		userDto.setRole("veterinarian");
		this.service.createVeterinarian(userDto);
		System.out.println("se ha creado el usuario exitosamente");
    }


}
