package by.givebook.repositories;

/**
 * Created by operb_000 on 16.10.2015.
 */
import by.givebook.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
