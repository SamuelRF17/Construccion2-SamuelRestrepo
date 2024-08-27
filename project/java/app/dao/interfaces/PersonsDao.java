package project.java.app.dao.interfaces;

import project.java.app.DTO.PersonsDto;

public interface PersonsDao {
    public boolean existsByDocument(PersonsDto personDto) throws Exception;
	public void createPerson(PersonsDto personDto) throws Exception;
	public void deletePerson(PersonsDto personDto) throws Exception;
	public PersonsDto findByDocument(PersonsDto personDto) throws Exception;
}
