package by.givebook.services;

import by.givebook.entities.library.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
public interface SimpleService<E> {
    E get(Long id);
    List<E> getAll();
    List<E> getAll(int page, int size);
    void delete(Long id);
    void save(E entity);
}
