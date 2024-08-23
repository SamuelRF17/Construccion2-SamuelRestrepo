package project.java.app.service.interfaces;
import project.java.app.DTO.UserDto;


public interface LoginService {
	public void login(UserDto userDto) throws Exception;
    public void logout();
    
}
