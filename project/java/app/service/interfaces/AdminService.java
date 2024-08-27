package project.java.app.service.interfaces;

import project.java.app.DTO.UserDto;

public interface AdminService {
    public void createSeller(UserDto userDto) throws Exception;

	public void createUser(UserDto userDto) throws Exception;
} 