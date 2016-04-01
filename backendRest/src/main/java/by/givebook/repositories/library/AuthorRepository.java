package by.givebook.repositories.library;

import by.givebook.entities.library.Author;
import by.givebook.repositories.SimpleRepository;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 02.03.2016
 */
public interface AuthorRepository extends SimpleRepository<Author> {
    Author getByLastNameAndFirstNameAndMiddleNameIgnoreCase(String lastName, String firstName, String middleName);
}
