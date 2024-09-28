/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.Interfaces.UserDao;
import app.dto.UserDto;

/**
 *
 * @author ESTUDIANTES
 */
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
