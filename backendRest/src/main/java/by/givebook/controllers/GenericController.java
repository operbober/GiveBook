package by.givebook.controllers;

import by.givebook.entities.IdEntity;
import by.givebook.services.SimpleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.MappedSuperclass;
import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 05.03.2016
 */
@MappedSuperclass
public abstract class GenericController<E extends IdEntity, S extends SimpleService<E>> {

    protected S service;

    protected GenericController(S service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    protected List<E> get() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    protected E getById(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    protected void addOrUpdate(@RequestBody E entity) {
        service.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    protected void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
