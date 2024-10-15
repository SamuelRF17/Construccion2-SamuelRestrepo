/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.repository;

import app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ACER
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    public boolean existsByCedula(long cedula);

    // public PersonDto createPerson(Person personDto) throws Exception;

    public Person findByCedula(long cedula);
    
}
