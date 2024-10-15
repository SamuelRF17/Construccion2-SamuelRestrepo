/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.Interfaces;

import app.dto.PersonDto;
import app.model.Person;

/**
 *
 * @author ESTUDIANTES
 */
public interface PersonDao {
	public boolean existsByDocument(Person personDto) throws Exception;
	public PersonDto createPerson(Person personDto) throws Exception;
	public void deletePerson(Person personDto) throws Exception;
	public PersonDto findByDocument(Person personDto) throws Exception;
    
}
