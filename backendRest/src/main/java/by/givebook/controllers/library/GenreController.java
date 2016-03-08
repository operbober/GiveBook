package by.givebook.controllers.library;

import by.givebook.controllers.SimpleController;
import by.givebook.entities.library.Genre;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
* Default class description.
*
* @author  P.Sinitski
* @version 1.0
* @since   01.03.2016
*/
@RestController
@RequestMapping("/genres")
public class GenreController extends SimpleController<Genre> {

    @Autowired
    public GenreController(@Qualifier("genreService") SimpleService<Genre> service) {
        super(service);
    }
}