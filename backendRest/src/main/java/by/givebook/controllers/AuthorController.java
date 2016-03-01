package by.givebook.controllers;

import by.givebook.controllers.superControllers.SimpleController;
import by.givebook.entities.Author;
import by.givebook.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by operb_000 on 01.03.2016.
 */
@RestController
@RequestMapping("/authors")
public class AuthorController extends SimpleController{

    @Autowired
    AuthorService authors;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> get(@RequestParam(value = "id", required = false) Long id){
        Map<String, Object> response = new HashMap<>();
        if (id == null){
            response.put("authors", authors.getAll());
            return response;
        }else{
            response.put("author", authors.get(id));
            return response;
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public boolean addOrUpdate(@RequestBody Author author){
        if (author.getId() == null) {
            return authors.add(author.getName());
        }
        else{
            return authors.update(author.getId(), author.getName());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Long id){
        return authors.delete(id);
    }
}
