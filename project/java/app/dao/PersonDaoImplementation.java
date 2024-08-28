package project.java.app.dao;

import project.java.app.dao.interfaces.PersonDao;
import project.java.app.DTO.PersonDto;

public class PersonDaoImplementation implements PersonDao {  

    public PersonDto findByDocument(PersonDto personDto) throws Exception {
        
        return null; 
    }
    
    public boolean existsByDocument(PersonDto personDto) throws Exception {
        return false; 
    }
    
    public void createPerson(PersonDto personDto) throws Exception {
    
    }
    
    public void deletePerson(PersonDto personDto) throws Exception {
    
    }
    
}
