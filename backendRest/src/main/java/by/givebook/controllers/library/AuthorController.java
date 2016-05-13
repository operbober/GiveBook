package by.givebook.controllers.library;

import by.givebook.controllers.GenericController;
import by.givebook.entities.library.Author;
import by.givebook.services.library.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 01.03.2016
 */
@RestController
@RequestMapping("/authors")
public class AuthorController extends GenericController<Author, AuthorService> {

    @Autowired
    public AuthorController(AuthorService service) {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    protected List<Author> getById(@RequestParam("lastName") String lastName,
                                   @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                   @RequestParam(value = "size", required = false, defaultValue = "3") int size) {
        return service.getSearchResults(lastName, page, size);
    }
}
