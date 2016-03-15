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
public class AuthorServiceImpl extends SimpleServiceImpl<Author, AuthorRepository> implements AuthorService{

    @Override
    public Author save(Author entity) {
        if (repository.getByLastNameAndFirstNameAndMiddleNameIgnoreCase(entity.getLastName(), entity.getFirstName(), entity.getMiddleName()) == null){
            super.save(entity);
        } else {
            entity = repository.getByLastNameAndFirstNameAndMiddleNameIgnoreCase(entity.getLastName(), entity.getFirstName(), entity.getMiddleName());
        }
        return entity;
    }
}
