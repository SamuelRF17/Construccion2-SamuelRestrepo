package app.service.interfaces;

import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.UserDto;

public interface AdminService {
    public void createInvoice(InvoiceDto invoiceDto) throws Exception; 
    public UserDto createUser(UserDto userDto) throws Exception;
    public boolean approveVIPRequest(PartnerDto partnerDto)throws Exception;
}
