package by.givebook.repositories.account;

import by.givebook.entities.account.User;
import by.givebook.repositories.SimpleRepository;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 02.03.2016
 */
public interface UserRepository extends SimpleRepository<User> {

    User findByLoginIgnoreCase(String login);

    User findByEmailIgnoreCase(String email);
}
