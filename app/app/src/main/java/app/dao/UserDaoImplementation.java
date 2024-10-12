package app.dao;

import app.dao.Interfaces.UserDao;
import app.dao.jpainterface.UserRepository;
import app.dto.UserDto;
import app.helpers.Helper;
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
public class UserDaoImplementation implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findByUserName(UserDto userDto) throws Exception {
        User user = userRepository.findByUserName(userDto.getUserName());
        return Helper.parse(user);
    }

    @Override
    public boolean existsByUserName(UserDto userDto) throws Exception {
        return userRepository.existsByUserName(userDto.getUserName());
    }

    @Override
    public void createUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        userRepository.save(user);
    }
}
