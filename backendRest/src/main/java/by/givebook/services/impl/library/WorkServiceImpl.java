package by.givebook.services.impl.library;

import by.givebook.entities.library.Author;
import by.givebook.entities.library.Work;
import by.givebook.repositories.library.WorkRepository;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.library.AuthorService;
import by.givebook.services.library.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by operb_000 on 11.03.2016.
 */
@Service
public class WorkServiceImpl extends SimpleServiceImpl<Work, WorkRepository> implements WorkService{

    @Autowired
    AuthorService authorService;

    @Override
    @Transactional
    public Work save(Work entity) {
        for (int i = 0; i < entity.getAuthors().size(); i++){
            entity.getAuthors().set(i, authorService.save(entity.getAuthors().get(i)));
        }

        if (repository.getTop1ByNameAndAuthors(entity.getName(), entity.getAuthors()) == null){
            super.save(entity);
        } else {
            entity = repository.getTop1ByNameAndAuthors(entity.getName(), entity.getAuthors());
        }
        return entity;
    }
}
