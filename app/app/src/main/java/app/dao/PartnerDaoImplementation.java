package app.dao;

import app.dao.Interfaces.PartnerDao;
import app.dao.repository.PartnerRepository;
import app.dto.PartnerDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Partner;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class PartnerDaoImplementation implements PartnerDao {
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public PartnerDto findById(long id) throws Exception {
        Partner partner = partnerRepository.findById(id).orElse(null);
        if (partner == null) {
            return null;
        }
        return Helper.parse(partner);
    }

    @Override
    public void save(PartnerDto partnerDto) throws Exception {
        Partner partner = Helper.parse(partnerDto);
        partnerRepository.save(partner);
    }

    @Override
    public long countVIPs() throws Exception {
        return partnerRepository.countByType("VIP");
    }

    @Override
    public PartnerDto findByPartner(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        Partner userFound = partnerRepository.findByUserId_Id(user.getId());
        return Helper.parse(userFound);
    }

    @Override
    public void updatePartner(PartnerDto partnerDto) throws Exception {
        Partner partner = Helper.parse(partnerDto);
        partnerRepository.save(partner);
    }
}
