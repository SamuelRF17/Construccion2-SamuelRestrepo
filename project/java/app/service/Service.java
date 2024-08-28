package project.java.app.service;

import project.java.app.dao.UserDaoImplementation;
import project.java.app.DTO.UserDto;
import project.java.app.dao.interfaces.UserDao;
import project.java.app.service.interfaces.LoginService;

public class Service implements LoginService {
	private UserDao userDao;


    public static UserDto user;

    public Service() {
		this.userDao = new UserDaoImplementation();
    }

    @Override
	public void login(UserDto userDto) throws Exception {
		// UserDto validateDto = userDao.findByUserName(userDto);
		// if (validateDto == null) {
		// 	throw new Exception("no existe usuario registrado");
		// }
		// if (!userDto.getPassword().equals(validateDto.getPassword())) {
		// 	throw new Exception("usuario o contraseña incorrecto");
		// }
		// userDto.setRole(validateDto.getRole());
		// user = validateDto;
	}

	@Override
	public void logout() {
		user = null;
		System.out.println("se ha cerrado sesion");
	}
    
}
