package app.controller;

import app.controller.requests.CreateGuestRequest;
import app.controller.requests.IncresedFoundsRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Person;
import app.service.Service;
import app.service.interfaces.AdminService;
import app.service.interfaces.PartnerService;
import app.service.interfaces.PersonService;
import app.service.interfaces.UserService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@NoArgsConstructor
@RestController
public class PartnerController implements ControllerInterface {

    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private AdminService adminService;
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private UserService userService;
    @Autowired
    private Service service;
    @Autowired
    private PersonService personService;

    @Override
    public void session() throws Exception {

    }

    @PostMapping("/CreateGuest")
    private ResponseEntity createGuest(@RequestBody CreateGuestRequest request) throws Exception {
        try {
            String name = request.getName();
            personValidator.validName(name);

            String document = request.getDocument();
            personValidator.validDocument(document);
            String celPhone = request.getCelPhone();
            personValidator.validCelPhone(celPhone);
            String guestUserName = request.getUserName();
            userValidator.validUserName(guestUserName);
            String password = request.getPassword();
            userValidator.validPassword(password);

            long partnerId = personValidator.validPartnerId(request.getPartnerId());

            Person person = new Person();
            person.setName(name);
            person.setCedula(Long.parseLong(document));
            person.setCelphone(Long.parseLong(celPhone));
            PersonDto newPersonDto = this.service.createPerson(person);

            UserDto userDto = new UserDto();
            userDto.setUserName(guestUserName);
            userDto.setPassword(password);
            userDto.setPersonId(Helper.parse(person));
            userDto.setPersonId(newPersonDto);
            userDto.setRol("invitado");
            UserDto newUserDto = this.service.createUser(userDto);

            PartnerDto partnerDto = new PartnerDto();
            partnerDto.setId(partnerId);

            GuestDto guestDto = new GuestDto();
            guestDto.setUserId(newUserDto);
            guestDto.setPartnerId(partnerDto);
            guestDto.setStatus(false);

            service.createGuest(guestDto);

            return new ResponseEntity<>("|---se ha creado el invitado exitosamente---|", HttpStatus.OK);

        } catch (Exception e) {
            for (StackTraceElement es : e.getStackTrace()) {
                System.out.println(es.toString());
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private void requestVip() throws Exception {
        PartnerDto partnerDto = service.getPartner();

        if (partnerDto.getType().equals("VIP")) {
            System.out.println("Ya eres un socio VIP");
            return;
        }
        if (!service.approveVIPRequest(partnerDto)) {
            System.out.println("No hay cupos disponibles para socios VIP");
        }
    }

    @PostMapping("/increaseFounds")
    private ResponseEntity increaseFounds(@RequestBody IncresedFoundsRequest request) throws Exception {
        try {
            long partnerId = personValidator.validPartnerId(request.getPartnerId());
            PartnerDto partnerDto = new PartnerDto();
            partnerDto.setId(partnerId);

            String amount = request.amount;
            double amountToIncrease = Double.parseDouble(amount);

            if (amountToIncrease <= 0) {
                return new ResponseEntity("|---ingrese un valor mas alto---|", HttpStatus.OK);
            }

            partnerDto.setAmount(partnerDto.getAmount() + amountToIncrease);
            service.updatePartner(partnerDto);

            return new ResponseEntity("|---Se ha aumentado el monto de su cuenta exitosamente---|", HttpStatus.OK);
        } catch (Exception e) {
            for (StackTraceElement es : e.getStackTrace()) {
                System.out.println(es.toString());
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
