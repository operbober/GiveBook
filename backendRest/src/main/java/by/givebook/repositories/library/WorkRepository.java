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
    @Query("SELECT w " +
            "FROM Work w " +
            "JOIN w.authors a " +
            "WHERE w.name = :name " +
            "AND a IN (:authors) " +
            "AND w in (" +
                "SELECT w2 " +
                "FROM Work w2 " +
                "JOIN w2.authors a2 " +
                "GROUP BY w2 " +
                "HAVING COUNT(a2) = :authorsSize" +
                ")"+
            "GROUP BY w " +
            "HAVING COUNT (a) = :authorsSize")
    Work findByNameAndAuthors(@Param("name") String name, @Param("authors") List<Author> authors, @Param("authorsSize") Long authorsSize);

    @Query(value = "Select w from Work w where w.name like %:title%")
    List<Work> findByTitleIgnoreCase(@Param("title") String title);
}
