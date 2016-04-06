package by.givebook.services.security;

import by.givebook.dto.security.UserLoginDTO;
import by.givebook.entities.account.User;

/**
 * Default class description.
 *
 * @author P.Sinitsky.
 * @date 08.03.2016.
 */
public interface LoginService {

    public Boolean isAuthenticated(UserLoginDTO userLoginDTO);

    public String getKeyForToken(UserLoginDTO userLoginDTO, String ipAddress);
}
