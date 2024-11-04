package app.dao;

import app.dao.Interfaces.UserDao;
import app.dao.repository.UserRepository;
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
    public UserDto findByUserName(String userName) throws Exception {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            return null;
        }
        return Helper.parse(user);
    }

    @Override
    public String existsByUserName(String userDto) throws Exception {
        return userRepository.existsByUserName(userDto);
    }

    @Override
    public UserDto createUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        User newUser = userRepository.save(user);
        return Helper.parse(newUser);
    }
}
