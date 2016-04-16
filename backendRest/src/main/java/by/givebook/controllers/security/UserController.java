package by.givebook.controllers.security;

/**
 * Created by operb_000 on 26.02.2016.
 */

import by.givebook.controllers.GenericController;
import by.givebook.entities.account.User;
import by.givebook.services.SimpleService;
import by.givebook.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends GenericController<User, SimpleService<User>> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }
}

