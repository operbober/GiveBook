package by.givebook.controllers;

import by.givebook.entities.IdEntity;
import by.givebook.services.SimpleService;

import javax.persistence.MappedSuperclass;
import javax.servlet.*;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 29.02.2016
 */

@MappedSuperclass
public abstract class SimpleEntityController<E extends IdEntity> extends GenericEntityController<E, SimpleService<E>>
        implements Filter {

    protected SimpleEntityController(SimpleService<E> service) {
        super(service);
    }
}
