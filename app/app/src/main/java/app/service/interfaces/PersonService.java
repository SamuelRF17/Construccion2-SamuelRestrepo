package app.service.interfaces;

import app.dto.PersonDto;
import app.model.Person;

public interface PersonService {
    public PersonDto createPerson(Person personDto) throws Exception;
    
}
