package by.givebook.services.impl.library;

import by.givebook.entities.library.Author;
import by.givebook.repositories.library.AuthorRepository;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.library.AuthorService;
import org.springframework.stereotype.Service;

/**
 * Created by operb_000 on 11.03.2016.
 */
@Service
public class AuthorServiceImpl extends SimpleServiceImpl<Author, AuthorRepository> implements AuthorService {

    @Override
    public Author getOldOrCreateNew(Author entity) {
        Author storedAuthor = getByFullName(entity);
        if (storedAuthor == null){
            super.save(entity);
            storedAuthor = getByFullName(entity);
        }
        return storedAuthor;
    }

    private Author getByFullName(Author entity){
        return repository.findByLastNameAndFirstNameAndMiddleNameAllIgnoreCase
                (entity.getLastName(), entity.getFirstName(), entity.getMiddleName());
    }
}
