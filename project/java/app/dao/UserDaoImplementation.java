package project.java.app.dao;

import project.java.app.dao.interfaces.UserDao;
import project.java.app.DTO.UserDto;

public class UserDaoImplementation implements UserDao {  

    public UserDto findByUserName(UserDto userDto) throws Exception {
        return null; 
    }
    
    public boolean existsByUserName(UserDto userDto) throws Exception {
        return false; 
    }
    
    public void createUser(UserDto userDto) throws Exception {
    
    }
}
