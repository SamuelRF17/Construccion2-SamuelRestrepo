/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.jpainterface;

import app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ACER
 */
public interface PersonRepository extends JpaRepository<Person, Long>{

    public boolean existsByCedula(long cedula);

    public Person findByCedula(long cedula);
    
}
