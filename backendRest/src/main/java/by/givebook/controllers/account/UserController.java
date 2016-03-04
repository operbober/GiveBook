package by.givebook.controllers.account;

/**
 * Created by operb_000 on 26.02.2016.
 */

import by.givebook.controllers.SimpleController;
import by.givebook.entities.account.User;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends SimpleController<User> {

    @Autowired
    public UserController(@Qualifier("userService") SimpleService<User> service) {
        super(service);
    }
}

