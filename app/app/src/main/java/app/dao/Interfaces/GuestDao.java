/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.Interfaces;

import app.dto.GuestDto;

/**
 *
 * @author ESTUDIANTES
 */
public interface GuestDao {
    public GuestDto findById(long id) throws Exception;
    public void saveGuest(GuestDto guestDto) throws Exception;
    public void createGuest(GuestDto guestDto) throws Exception;
}
