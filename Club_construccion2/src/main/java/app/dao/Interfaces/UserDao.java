/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.Interfaces;

import app.dto.UserDto;


/**
 *
 * @author ESTUDIANTES
 */
public interface UserDao {
    public UserDto findByUserName(UserDto userDto) throws Exception;

	public boolean existsByUserName(UserDto userDto) throws Exception;
	
	public void createUser(UserDto userDto) throws Exception;
    
}