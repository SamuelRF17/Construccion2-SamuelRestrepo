package project.java.app.controller.validator;

import project.java.app.DTO.UserDto;
import project.java.app.service.Service;


public class LoginController implements ControllerInterface {
    private Service service;

    public LoginController() {
        service = new Service();
    }

    public void login(UserDto userDto) throws Exception {
        service.login(userDto);
    }

    public void logout() {
        service.logout();
    }

    @Override
    public void session() throws Exception {
        if (Service.user == null) {
            throw new Exception("no hay sesion iniciada");
        }
    }
   

    
}
