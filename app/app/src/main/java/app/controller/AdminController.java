package app.controller;

import app.controller.requests.CreateGuestRequest;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Person;
import app.service.Service;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@NoArgsConstructor
@RestController
public class AdminController implements ControllerInterface {

    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private Service service;

    @Override
    public void session() throws Exception {
    }

    @PostMapping("/CrearUsuario")
    public ResponseEntity createUser(@RequestBody CreateGuestRequest request) throws Exception {
        try {
            String name = request.getName();
            personValidator.validName(name);
            String document = request.getDocument();
            personValidator.validDocument(document);
            String celPhone = request.getCelPhone();
            personValidator.validCelPhone(celPhone);
            String userName = request.getUserName();
            userValidator.validUserName(userName);
            String password = request.getPassword();
            userValidator.validPassword(password);
            
            Person person = new Person();
            person.setName(name);
            person.setCedula(Long.parseLong(document));
            person.setCelphone(Long.parseLong(celPhone));
            PersonDto newPersonDto = this.service.createPerson(person);

            UserDto userDto = new UserDto();
            userDto.setUserName(userName);
            userDto.setPassword(password);
            userDto.setPersonId(Helper.parse(person));
            userDto.setPersonId(newPersonDto);
            userDto.setRol("socio");
            UserDto newUserDto = this.service.createUser(userDto);

            PartnerDto partnerDto = new PartnerDto();
            partnerDto.setUserId(newUserDto);
            partnerDto.setAmount(50000);
            partnerDto.setType("standard");
            partnerDto.setDateCreated(new Date(System.currentTimeMillis()));
            this.service.save(partnerDto);

            System.out.println("|---se ha creado el usuario exitosamente---|");
            return new ResponseEntity<>("|---se ha creado el usuario exitosamente---|", HttpStatus.OK);

        } catch (Exception e) {
            for (StackTraceElement es : e.getStackTrace()) {
                System.out.println(es.toString());
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
