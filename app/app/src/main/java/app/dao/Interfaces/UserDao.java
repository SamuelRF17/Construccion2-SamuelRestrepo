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
    public UserDto findByUserName(String userDto) throws Exception;

	public String existsByUserName(String userDto) throws Exception;
	
	public UserDto createUser(UserDto userDto) throws Exception;
    
}