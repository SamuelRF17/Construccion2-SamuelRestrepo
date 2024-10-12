package app.helpers;

import app.dto.*;
import app.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static PersonDto parse(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setCedula(person.getCedula());
        personDto.setName(person.getName());
        personDto.setCelPhone(person.getCelphone()); // Añadido para completar la conversión
        return personDto;
    }

    public static Person parse(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getId());
        person.setCedula(personDto.getCedula());
        person.setName(personDto.getName());
        person.setCelphone(personDto.getCelPhone()); // Añadido para completar la conversión
        return person;
    }

    public static UserDto parse(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setPersonId(parse(user.getPersonId()));
        userDto.setRol(user.getRol());
        userDto.setUserName(user.getUserName());
        return userDto;
    }

    public static User parse(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setPersonId(parse(userDto.getPersonId()));
        user.setRol(userDto.getRol());
        user.setUserName(userDto.getUserName());
        return user;
    }

    public static GuestDto parse(Guest guest) {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setUserId(guest.getUserId() != null ? parse(guest.getUserId()) : null);
        guestDto.setPartnerId(parse(guest.getPartnerId()));
        guestDto.setStatus(guest.getStatus());
        return guestDto;
    }

    public static Guest parse(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setUserId(parse(guestDto.getUserId()));
        guest.setPartnerId(parse(guestDto.getPartnerId()));
        guest.setStatus(guestDto.getStatus());
        return guest;
    }

    public static PartnerDto parse(Partner partner) {
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setId(partner.getId());
        partnerDto.setUserId(partner.getUserId());
        partnerDto.setAmount(partner.getAmount());
        partnerDto.setType(partner.getType());
        partnerDto.setDateCreated(partner.getDateCreated());
        return partnerDto;
    }

    public static Partner parse(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setId(partnerDto.getId());
        partner.setUserId(partnerDto.getUserId());
        partner.setAmount(partnerDto.getAmount());
        partner.setType(partnerDto.getType());
        partner.setDateCreated(partnerDto.getDateCreated());
        return partner;
    }

    public static InvoiceDto parse(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId(invoice.getInvoiceId());
        invoiceDto.setPersonId(parse(invoice.getPersonId()));
        invoiceDto.setPartnerId(parse(invoice.getPartnerId()));
        invoiceDto.setDateCreated(invoice.getDateCreated());
        invoiceDto.setAmount(invoice.getAmount());
        invoiceDto.setStatus(invoice.getStatus());
        return invoiceDto;
    }

    public static Invoice parse(InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceDto.getInvoiceId());
        invoice.setPersonId(parse(invoiceDto.getPersonId()));
        invoice.setPartnerId(parse(invoiceDto.getPartnerId()));
        invoice.setDateCreated(invoiceDto.getDateCreated());
        invoice.setAmount(invoiceDto.getAmount());
        invoice.setStatus(invoiceDto.getStatus());
        return invoice;
    }

    public static InvoiceDetailDto parse(InvoiceDetail invoiceDetail) {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        invoiceDetailDto.setId(invoiceDetail.getId());
        invoiceDetailDto.setInvoiceId(parse(invoiceDetail.getInvoiceId()));
        invoiceDetailDto.setItem(invoiceDetail.getItem());
        invoiceDetailDto.setDescription(invoiceDetail.getDescription());
        invoiceDetailDto.setAmount(invoiceDetail.getAmount());
        return invoiceDetailDto;
    }

    public static InvoiceDetail parse(InvoiceDetailDto invoiceDetailDto) {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setId(invoiceDetailDto.getId());
        invoiceDetail.setInvoiceId(parse(invoiceDetailDto.getInvoiceId()));
        invoiceDetail.setItem(invoiceDetailDto.getItem());
        invoiceDetail.setDescription(invoiceDetailDto.getDescription());
        invoiceDetail.setAmount(invoiceDetailDto.getAmount());
        return invoiceDetail;
    }

    // Métodos para convertir listas
    public static List<PersonDto> parsePersons(List<Person> persons) {
        return persons.stream().map(Helper::parse).collect(Collectors.toList());
    }

    public static List<UserDto> parseUsers(List<User> users) {
        return users.stream().map(Helper::parse).collect(Collectors.toList());
    }

    public static List<GuestDto> parseGuests(List<Guest> guests) {
        return guests.stream().map(Helper::parse).collect(Collectors.toList());
    }

    public static List<PartnerDto> parsePartners(List<Partner> partners) {
        return partners.stream().map(Helper::parse).collect(Collectors.toList());
    }

    public static List<InvoiceDto> parseInvoices(List<Invoice> invoices) {
        return invoices.stream().map(Helper::parse).collect(Collectors.toList());
    }

    public static List<InvoiceDetailDto> parseInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        return invoiceDetails.stream().map(Helper::parse).collect(Collectors.toList());
    }
}
