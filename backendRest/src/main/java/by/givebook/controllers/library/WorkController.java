package by.givebook.controllers.library;

import by.givebook.controllers.GenericController;
import by.givebook.entities.library.Work;
import by.givebook.services.SimpleService;
import by.givebook.services.library.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 02.03.2016
 */
@RestController
@RequestMapping("/works")
public class WorkController extends GenericController<Work, WorkService> implements javax.servlet.Filter {

    @Autowired
    public WorkController(WorkService service) {
        super(service);
    }
}
