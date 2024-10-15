/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.service.interfaces;

import app.dto.GuestDto;

/**
 *
 * @author ACER
 */
public interface GuestService {
    public void createGuest(GuestDto guestDto) throws Exception;
    public GuestDto findById(long id) throws Exception;
}
