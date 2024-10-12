package app.service;

import app.dao.Interfaces.GuestDao;
import app.dao.Interfaces.UserDao;
import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.UserDto;
import app.model.Partner;
import app.service.interfaces.AdminService;
import app.service.interfaces.LoginService;
import app.service.interfaces.PartnerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
@NoArgsConstructor
@Getter
@Setter
public class Service implements AdminService, LoginService, PartnerService{
    
    
    
    @Autowired
    private UserDao userDao;
    @Autowired
    private GuestDao guestDao; 
    public static UserDto user;

    @Override
    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUserName(userDto);
        if (validateDto == null) {
                throw new Exception("no existe usuario registrado");
        }
        if (!userDto.getPassword().equals(validateDto.getPassword())) {
            throw new Exception("usuario o contraseña incorrecto");
        }
        userDto.setRol(validateDto.getRol());
        user = validateDto;
    }

    @Override
    public void logout() {
        user = null;
        System.out.println("se ha cerrado sesion");
    }

    @Override
    public void createUser(UserDto user){
       this.createUser(user);
    }	

    @Override
    public void createSeller(UserDto userDto) throws Exception {
        this.createSeller(userDto);
    }

    @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName(guestDto.getUserId().getUserName());
        this.createUser(userDto);
        guestDao.createGuest(guestDto);
    }

    @Override
    public long countVIPs() {
        return this.countVIPs();
    }

    @Override
    public boolean approveVIPRequest(Partner partner) {
        return this.approveVIPRequest(partner); 
    }

    @Override
    public boolean hasVIPSlotsAvailable() {
        return this.hasVIPSlotsAvailable();
    }

    @Override
    public void saveGuest(GuestDto guestDto) {
        this.saveGuest(guestDto);
    }

    @Override
    public PartnerDto findByUserName(String userName) {
        return this.findByUserName(userName);

        }

    @Override
    public void save(PartnerDto partnerDto) {
            this.save(partnerDto);

    }

}
