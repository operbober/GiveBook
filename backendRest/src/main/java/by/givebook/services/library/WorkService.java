package by.givebook.services.library;

import by.givebook.entities.library.Work;
import by.givebook.services.SimpleService;

import java.util.List;

/**
 * Created by operb_000 on 11.03.2016.
 */
public interface WorkService extends SimpleService<Work> {

    List<Work> getSearchResults(String name, int page, int size);

    Work getOldOrCreateNew(Work entity);
}
