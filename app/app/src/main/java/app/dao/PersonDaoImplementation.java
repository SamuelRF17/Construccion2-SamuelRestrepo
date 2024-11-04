package app.dao;

import app.dao.Interfaces.PersonDao;
import app.dao.repository.PersonRepository;
import app.dto.PersonDto;
import app.helpers.Helper;
import app.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class PersonDaoImplementation implements PersonDao {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean existsByDocument(Person personDto) throws Exception {
        return personRepository.existsByCedula(Helper.parse(personDto).getCedula());
    }

    @Override
    public PersonDto createPerson(Person personDto) throws Exception {
        try {
            Person savedPerson = personRepository.save(personDto);
            return Helper.parse(savedPerson);
        } catch (Exception e) {
            throw new Exception("Error al crear persona: " + e.getMessage());
        }
    }

    @Override
    public void deletePerson(Person personDto) throws Exception {
        try {
            personRepository.delete(personDto);
        } catch (Exception e) {
            throw new Exception("Error al eliminar persona: " + e.getMessage());
        }
    }

    @Override
    public PersonDto findByDocument(Person personDto) throws Exception {
        Person person = personRepository.findByCedula(personDto.getCedula());
        if (person == null) {
            return null;
        }
        return Helper.parse(person);
    }
}
