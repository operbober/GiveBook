package by.givebook.services.impl.secutiry;

import by.givebook.dto.security.UserLoginDTO;
import by.givebook.entities.account.User;
import by.givebook.repositories.account.UserRepository;
import by.givebook.services.security.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
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
    public Boolean isAuthenticated(UserLoginDTO userLoginDTO) {

        User user = userRepository.findByLoginIgnoreCase(userLoginDTO.getLogin());

        if (user == null){
            return null;
        }

        return userLoginDTO.getPassword().equals(user.getPassword());
    }

    @Override
    public String getKeyForToken(UserLoginDTO userLoginDTO, String ipAddress) {
        return DigestUtils.sha1Hex(userLoginDTO.getLogin() + userLoginDTO.getPassword() + ipAddress);
    }
}
