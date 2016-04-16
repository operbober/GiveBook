package by.givebook.services.library;

import by.givebook.entities.library.Author;
import by.givebook.services.SimpleService;

/**
 * Created by operb_000 on 11.03.2016.
 */
public interface AuthorService extends SimpleService<Author> {

    public Author getOldOrCreateNew(Author author);
}
