/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.Interfaces;

import app.dto.PersonDto;

/**
 *
 * @author ESTUDIANTES
 */
public interface PersonDao {
	public boolean existsByDocument(PersonDto personDto) throws Exception;
	public void createPerson(PersonDto personDto) throws Exception;
	public void deletePerson(PersonDto personDto) throws Exception;
	public PersonDto findByDocument(PersonDto personDto) throws Exception;
    
}
