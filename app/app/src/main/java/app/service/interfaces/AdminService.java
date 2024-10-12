package app.service.interfaces;

import app.dto.UserDto;
import app.model.Partner;

public interface AdminService {
    public void createSeller(UserDto userDto) throws Exception;
    public void createUser(UserDto userDto) throws Exception;
    public boolean approveVIPRequest(Partner partner);
}
