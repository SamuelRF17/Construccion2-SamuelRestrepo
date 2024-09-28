package app.dao;

import app.dao.Interfaces.PersonDao;
import app.dao.jpainterface.PersonRepository;
import app.dto.PersonDto;
import app.helpers.Helper;
import app.model.Person;


public class PersonDaoImplementation implements PersonDao {
    
    PersonRepository personRepository;
    @Override
    public boolean existsByDocument(PersonDto personDto) throws Exception {
        return personRepository.existByDocument(Helper.parse(personDto).getCedula());
    }
    
    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        Person person = Helper.parse(personDto);
        personRepository.save(person);
    }
    @Override
    
    public void deletePerson(PersonDto personDto) throws Exception {
        Person person = Helper.parse(personDto);
        personRepository.delete(person);
    }
    
    @Override
    public PersonDto findByDocument(PersonDto personDto) throws Exception {
        Person person = personRepository.findByDocument(personDto.getCedula()); 
        return Helper.parse(person); 
    }   
}
