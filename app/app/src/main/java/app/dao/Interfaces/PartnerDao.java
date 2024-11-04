/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.Interfaces;

import app.dto.PartnerDto;
import app.dto.UserDto;

/**
 *
 * @author ESTUDIANTES
 */
public interface PartnerDao {
    public PartnerDto findByPartner(UserDto userDto) throws Exception;
    public PartnerDto findById(long userId) throws Exception;
    public void updatePartner(PartnerDto partnerDto) throws Exception;
    public void save(PartnerDto partnerDto) throws Exception;
    public long countVIPs() throws Exception;
}
