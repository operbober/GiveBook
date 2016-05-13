package by.givebook.controllers.library;

import by.givebook.controllers.GenericController;
import by.givebook.entities.library.Work;
import by.givebook.services.library.WorkService;
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
 * @since 02.03.2016
 */
@RestController
@RequestMapping("/works")
public class WorkController extends GenericController<Work, WorkService> {

    @Autowired
    public WorkController(WorkService service) {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    protected List<Work> getById(@RequestParam("title") String title,
                                 @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                 @RequestParam(value = "size", required = false, defaultValue = "3") int size)
    {
        return service.getSearchResults(title, page, size);
    }
}
