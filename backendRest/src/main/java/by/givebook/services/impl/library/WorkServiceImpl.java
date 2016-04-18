package by.givebook.services.impl.library;

import by.givebook.entities.library.Work;
import by.givebook.repositories.library.WorkRepository;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.library.AuthorService;
import by.givebook.services.library.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by operb_000 on 11.03.2016.
 */
@Service
public class WorkServiceImpl extends SimpleServiceImpl<Work, WorkRepository> implements WorkService{

    @Autowired
    AuthorService authorService;

    @Override
    public List<Work> getSearchResults(String title) {
        return repository.findByTitleIgnoreCase(title);
    }

    @Transactional
    @Override
    public Work getOldOrCreateNew(Work entity) {
        if (entity.getAuthors() != null) {
            entity.getAuthors().replaceAll(authorService::getOldOrCreateNew);
        }
        Work storedWork = repository.findByNameAndAuthors(entity.getName(), entity.getAuthors());
        if (storedWork == null){
            super.save(entity);
            storedWork = repository.findByNameAndAuthors(entity.getName(), entity.getAuthors());
        }
        return storedWork;
    }
}
