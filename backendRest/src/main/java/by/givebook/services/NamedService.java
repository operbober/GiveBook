package by.givebook.services;

import by.givebook.entities.IdEntity;

import java.util.List;

/**
 * Created by operb_000 on 09.03.2016.
 */
public interface NamedService<E extends IdEntity> extends SimpleService<E> {
    E getByName(String name);
}
