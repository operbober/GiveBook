package by.givebook.repositories;

import by.givebook.entities.IdEntity;
import by.givebook.entities.NamedEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by operb_000 on 09.03.2016.
 */
@NoRepositoryBean
public interface NamedRepository<E extends NamedEntity> extends SimpleRepository<E> {
    E findByName(String name);
}
