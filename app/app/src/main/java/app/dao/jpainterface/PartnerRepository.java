/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.jpainterface;

import app.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ACER
 */
public interface PartnerRepository extends JpaRepository <Partner, Long> {
    public Partner findByUserId(Long userId);
    public long countByType(String type);
    
}
