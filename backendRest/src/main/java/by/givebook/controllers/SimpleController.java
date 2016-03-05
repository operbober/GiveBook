package by.givebook.controllers;

import by.givebook.entities.IdEntity;
import by.givebook.services.SimpleService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 29.02.2016
 */

@MappedSuperclass
public abstract class SimpleController<E extends IdEntity> extends GenericController<E, SimpleService<E>>
        implements Filter {

    protected SimpleController(SimpleService<E> service) {
        super(service);
    }
}
