package by.givebook.controllers;

/**
 * Created by operb_000 on 26.02.2016.
 */

import by.givebook.controllers.superControllers.SimpleController;
import by.givebook.entities.User;
import by.givebook.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController extends SimpleController {
    @Autowired
    UsersRepository users;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers()
    {
        List<User> result = new ArrayList<>();
        users.findAll().forEach(result::add);
        return result;
    }

}

