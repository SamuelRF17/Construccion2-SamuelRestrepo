package app.service.interfaces;

import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.UserDto;

public interface PartnerService {
    public void createGuest(GuestDto GuestDto) throws Exception;
    
    public long countVIPs() throws Exception;

    public void save(PartnerDto partnerDto) throws Exception;

    public void saveGuest(GuestDto guestDto) throws Exception;

    public boolean hasVIPSlotsAvailable() throws Exception;

    public void findPartner(UserDto userDto) throws Exception;

    public void updatePartner(PartnerDto partnerDto) throws Exception;

}

