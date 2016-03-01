package by.givebook.controllers;

import by.givebook.controllers.superControllers.SimpleController;
import by.givebook.entities.Author;
import by.givebook.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by operb_000 on 01.03.2016.
 */
@RestController
@RequestMapping("/authors")
public class AuthorController extends SimpleController {

    @Autowired
    AuthorService authors;

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> get() {
        return authors.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author getById(@PathVariable("id") Long id) {
        return authors.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public boolean addOrUpdate(@RequestBody Author author) {
        if (author.getId() == null) {
            return authors.add(author.getName());
        } else {
            return authors.update(author.getId(), author.getName());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Long id)
    {
        return authors.delete(id);
    }
}
