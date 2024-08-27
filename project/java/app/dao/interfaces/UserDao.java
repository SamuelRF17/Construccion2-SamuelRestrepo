package project.java.app.dao.interfaces;

import project.java.app.DTO.UserDto;

public interface UserDao {
	
    public UserDto findByUserName(UserDto userDto) throws Exception;

	public boolean existsByUserName(UserDto userDto) throws Exception;
	
	public void createUser(UserDto userDto) throws Exception;
}
