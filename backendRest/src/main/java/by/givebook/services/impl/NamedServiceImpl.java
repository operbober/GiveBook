package by.givebook.services.impl;

import by.givebook.entities.NamedEntity;
import by.givebook.repositories.NamedRepository;
import by.givebook.services.NamedService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by operb_000 on 09.03.2016.
 */
public abstract class NamedServiceImpl<E extends NamedEntity> extends SimpleServiceImpl<E> implements NamedService<E>{

    @Autowired
    NamedRepository<E> repository;

    @Override
    public E getByName(String name) {
        return repository.findByName(name);
    }
}
