package by.givebook.repositories;

/**
 * Created by operb_000 on 16.10.2015.
 */
import by.givebook.entities.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "usersRepository")
public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
