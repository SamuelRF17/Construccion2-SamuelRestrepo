package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import app.dao.Interfaces.GuestDao;
import app.dao.Interfaces.UserDao;
import app.dao.Interfaces.PartnerDao;
import app.dao.Interfaces.PersonDao;
import app.dao.Interfaces.InvoiceDao;
import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Person;
import app.service.interfaces.AdminService;
import app.service.interfaces.GuestService;
import app.service.interfaces.LoginService;
import app.service.interfaces.PartnerService;
import app.service.interfaces.PersonService;
import app.service.interfaces.UserService;

@org.springframework.stereotype.Service
@NoArgsConstructor
@Getter
@Setter
public class Service implements AdminService, LoginService, PartnerService, GuestService, UserService, PersonService{

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private GuestDao guestDao;
    
    @Autowired
    private PartnerDao partnerDao;
    
    @Autowired
    private InvoiceDao invoiceDao; 

    @Autowired
    private PersonDao personDao;
    
    private UserDto user;

    private PartnerDto partner;

    @Override
    public void login(UserDto userDto) throws Exception {
        UserDto userFound = userDao.findByUserName(userDto.getUserName());
        if (userFound == null) {
            throw new Exception("No existe usuario registrado");
        }
        if (!userDto.getPassword().equals(userFound.getPassword())) {
            throw new Exception("Usuario o contraseña incorrecto");
        }
        user = userFound;
        if (userFound.getRol().equals("partner")) {
            findPartner(userFound);
        }
    }

    @Override
    public void findPartner(UserDto userDto) throws Exception{
        PartnerDto partnerDto = partnerDao.findByPartner(userDto);
        if (partnerDto == null) {
            throw new Exception("No existe socio registrado");
        }
        partner = partnerDto;
    }

    @Override
    public void logout() {
        user = null;
        System.out.println("Se ha cerrado sesión");
    }

    @Override
    public UserDto createUser(UserDto userDto) throws Exception {
        UserDto userDtoFound = userDao.findByUserName(userDto.getUserName());
        if (userDtoFound == null) {
            return userDao.createUser(userDto);
        }
        return userDtoFound;
    }

    @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        UserDto userDto = guestDto.getUserId();
        createUser(userDto);
        guestDao.createGuest(guestDto);
    }

    @Override
    public long countVIPs() throws Exception {
        return partnerDao.countVIPs();
    }

    @Override
    public boolean approveVIPRequest(PartnerDto partnerDto) throws Exception {
        try {
            if (hasVIPSlotsAvailable()) {
                partnerDto.setType("VIP");
                partnerDao.save(partnerDto);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error al aprobar solicitud VIP: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean hasVIPSlotsAvailable() throws Exception {
        return countVIPs() < 5; 
    }

    @Override
    public void saveGuest(GuestDto guestDto) throws Exception {
        guestDao.saveGuest(guestDto);
    }

    @Override
    public void save(PartnerDto partnerDto) throws Exception {
        partnerDao.save(partnerDto);
    }

    @Override
    public String existsByUserName(String userName) throws Exception {
        return userDao.existsByUserName(userName);
    }

    @Override
    public void createInvoice(InvoiceDto invoiceDto) throws Exception {
        invoiceDao.createInvoice(invoiceDto); 
    }

    @Override
    public GuestDto findById(long id) throws Exception {
        return guestDao.findById(id);
    }

    @Override
    public PersonDto createPerson(Person personDto) throws Exception {
        PersonDto personDtoFound = personDao.findByDocument(personDto);
        if (personDtoFound == null) {
            return personDao.createPerson(personDto);
        }
        return personDtoFound;
    }

    @Override
    public void updatePartner(PartnerDto partnerDto) throws Exception {
        partnerDao.updatePartner(partnerDto);        
    }

}
