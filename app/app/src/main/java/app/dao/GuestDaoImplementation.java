package app.dao;

import app.dao.Interfaces.GuestDao;
import app.dao.jpainterface.GuestRepository;
import app.dto.GuestDto;
import app.helpers.Helper;
import app.model.Guest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class GuestDaoImplementation implements GuestDao {
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public GuestDto findById(long id) throws Exception {
        Guest guest = guestRepository.findById(id).orElse(null);
        return Helper.parse(guest);
    }

    @Override
    public void saveGuest(GuestDto guestDto) throws Exception {
        Guest guest = Helper.parse(guestDto);
        guestRepository.save(guest);
    }

    @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        saveGuest(guestDto);
    }
}
