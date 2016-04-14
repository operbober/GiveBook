package by.givebook.controllers.library;

import by.givebook.controllers.GenericController;
import by.givebook.entities.library.Genre;
import by.givebook.services.NamedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 01.03.2016
 */
@RestController
@RequestMapping("/genres")
public class GenreController extends GenericController<Genre, NamedService<Genre>> {

    @Autowired
    public GenreController(@Qualifier("genreService") NamedService<Genre> service) {
        super(service);
    }
}
