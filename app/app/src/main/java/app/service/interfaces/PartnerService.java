package app.service.interfaces;

import app.dto.GuestDto;
import app.dto.PartnerDto;

public interface PartnerService {
    public void createGuest(GuestDto GuestDto) throws Exception;

    public PartnerDto findByUserName(String userName);

    public long countVIPs();

    public void save(PartnerDto partnerDto);

    public void saveGuest(GuestDto guestDto);

    public boolean hasVIPSlotsAvailable();

}

