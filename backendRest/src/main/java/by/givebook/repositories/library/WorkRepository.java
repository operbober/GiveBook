package by.givebook.repositories.library;

import by.givebook.entities.library.Author;
import by.givebook.entities.library.Genre;
import by.givebook.entities.library.Work;
import by.givebook.repositories.SimpleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 03.03.2016
 */
public interface WorkRepository extends SimpleRepository<Work> {
    Work findByNameAndAuthors(String name, List<Author> authors);
}
