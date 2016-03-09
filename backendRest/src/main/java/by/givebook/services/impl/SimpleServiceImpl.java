package by.givebook.services.impl;

import by.givebook.entities.IdEntity;
import by.givebook.repositories.SimpleRepository;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
public abstract class SimpleServiceImpl<E extends IdEntity>
        implements SimpleService<E> {

    @Autowired
    SimpleRepository<E> repository;

    @Override
    public E get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<E> getAll() {
        List<E> entities = new ArrayList<>();
        repository.findAll().forEach(entities::add);
        return entities;
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void save(E entity) {
        repository.save(entity);
    }
}
