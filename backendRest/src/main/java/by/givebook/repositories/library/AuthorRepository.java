package by.givebook.repositories.library;

import by.givebook.entities.library.Author;
import by.givebook.repositories.SimpleRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 02.03.2016
 */
public interface AuthorRepository extends SimpleRepository<Author> {

    Author findByLastNameAndFirstNameAndMiddleNameAllIgnoreCase(String lastName, String firstName, String middleName);

    @Query(value = "Select c from Author c where c.lastName like :lastName%")
    List<Author> findByLastOrFirstNameIgnoreCase
            (@Param("lastName") String lastName);
}
