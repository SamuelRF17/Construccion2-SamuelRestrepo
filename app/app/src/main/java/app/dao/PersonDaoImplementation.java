package app.dao;

import app.dao.Interfaces.PersonDao;
import app.dao.jpainterface.PersonRepository;
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
    public boolean existsByDocument(PersonDto personDto) throws Exception {
        return personRepository.existsByCedula(Helper.parse(personDto).getCedula());
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
        Person person = personRepository.findByCedula(personDto.getCedula());
        return Helper.parse(person);
    }
}
