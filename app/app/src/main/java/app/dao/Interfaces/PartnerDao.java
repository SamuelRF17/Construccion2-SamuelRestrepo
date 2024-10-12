/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.Interfaces;

import app.dto.PartnerDto;

/**
 *
 * @author ESTUDIANTES
 */
public interface PartnerDao {
    public PartnerDto findById(long id) throws Exception;
    public void save(PartnerDto partnerDto) throws Exception;
    public long countVIPs() throws Exception;
}
