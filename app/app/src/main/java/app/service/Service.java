package app.service;

import java.sql.Date;
import java.sql.SQLException;

import app.dao.UserDaoImplementation;
import app.dao.Interfaces.UserDao;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.interfaces.AdminService;
import app.service.interfaces.LoginService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@org.springframework.stereotype.Service
@NoArgsConstructor
@Getter
@Setter
public class Service implements AdminService, LoginService{
    private UserDao userDao;
    //private MYSQLConnection connection = new MYSQLConnection();
    public static UserDto user;

    /*public Service() {
        this.userDao = new UserDaoImplementation();
    }*/

    @Override
    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUserName(userDto);
        if (validateDto == null) {
                throw new Exception("no existe usuario registrado");
        }
        // if (!userDto.getPassword().equals(validateDto.getPassword())) {
        // 	throw new Exception("usuario o contraseña incorrecto");
        // }
        userDto.setRol(validateDto.getRol());
        user = validateDto;
    }

    @Override
    public void logout() {
        user = null;
        System.out.println("se ha cerrado sesion");
    }

    @Override
    public void createUser(UserDto user){
       //this.createUser(user);
    }	

    @Override
    public void createSeller(UserDto userDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
