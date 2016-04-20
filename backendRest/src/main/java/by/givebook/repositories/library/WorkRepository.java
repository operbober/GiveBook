package by.givebook.repositories.library;

import by.givebook.entities.library.Author;
import by.givebook.entities.library.Work;
import by.givebook.repositories.SimpleRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query("SELECT w FROM Work w INNER JOIN w.authors a WHERE w.name = ?1 AND a IN (?2)")
    Work findOneByNameAndAuthors(String name, List<Author> authors);

    @Query(value = "Select w from Work w where w.name like %:title%")
    List<Work> findByTitleIgnoreCase(@Param("title") String title);
}
