package by.givebook.services.library;

import by.givebook.entities.library.Author;
import by.givebook.entities.library.Work;
import by.givebook.services.SimpleService;

import java.util.List;

/**
 * Created by operb_000 on 11.03.2016.
 */
public interface WorkService extends SimpleService<Work> {

    Work getOldOrCreateNew(Work entity);
}
