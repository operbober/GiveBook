package by.givebook.controllers.security;

import by.givebook.dto.UserRegisterDTO;
import by.givebook.entities.account.User;
import by.givebook.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 05.05.2016
 */

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.PUT)
    protected void register(@RequestBody UserRegisterDTO dto) {
        User user = new User(dto.getLogin(), dto.getEmail(), dto.getPassword());
        service.save(user);
    }
}
