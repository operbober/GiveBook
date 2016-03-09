package by.givebook.services.security;

import by.givebook.dto.UserLoginDTO;
import by.givebook.entities.account.User;
import by.givebook.repositories.SimpleRepository;
import by.givebook.repositories.account.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Default class description.
 *
 * @author P.Sinitsky.
 * @date 08.03.2016.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User isAuthenticated(UserLoginDTO userLoginDTO) {

        if (!userRepository.exists(1L)){
            return null;
        }

        User user = userRepository.findOne(1L);
        return userLoginDTO.getPassword().equals(user.getPassword()) ? user : null;
    }
}
