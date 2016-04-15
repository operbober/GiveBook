package by.givebook.services.security;

import by.givebook.entities.account.User;
import by.givebook.services.SimpleService;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 15.04.2016
 */
public interface UserService extends SimpleService<User> {

    public User getUserByLogin(String login);

    public User getUserByEmail(String email);
}
