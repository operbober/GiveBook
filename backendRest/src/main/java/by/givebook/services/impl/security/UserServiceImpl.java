package by.givebook.services.impl.security;

import by.givebook.entities.account.User;
import by.givebook.repositories.account.UserRepository;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.security.UserService;
import org.springframework.stereotype.Service;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 15.04.2016
 */
@Service
public class UserServiceImpl extends SimpleServiceImpl<User, UserRepository> implements UserService {

    @Override
    public User getUserByLogin(String login) {
        return repository.findByLoginIgnoreCase(login);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmailIgnoreCase(email);
    }
}
