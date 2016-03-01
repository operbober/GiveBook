package by.givebook.controllers;

/**
 * Created by operb_000 on 26.02.2016.
 */

import by.givebook.controllers.superControllers.SimpleController;
import by.givebook.entities.User;
import by.givebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController extends SimpleController {
    @Autowired
    UserService users;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers()
    {
        return users.getAll();
    }

}

