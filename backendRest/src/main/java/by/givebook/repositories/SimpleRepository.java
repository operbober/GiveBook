package by.givebook.repositories;

import by.givebook.entities.IdEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 02.03.2016
 */
@NoRepositoryBean
public interface SimpleRepository<E extends IdEntity> extends CrudRepository<E, Long> {
    Page<E> findAll(Pageable pageable);
}
