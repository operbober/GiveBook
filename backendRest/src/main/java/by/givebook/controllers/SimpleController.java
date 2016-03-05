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
public abstract class SimpleController<E extends IdEntity>
        implements Filter {

    SimpleService<E> service;

    protected SimpleController(SimpleService<E> service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<E> get() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private E getById(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    protected boolean addOrUpdate(@RequestBody E entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Long id)
    {
        return service.delete(id);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
