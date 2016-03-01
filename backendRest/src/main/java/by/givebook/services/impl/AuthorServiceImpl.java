package by.givebook.services.impl;

import by.givebook.entities.Author;
import by.givebook.repositories.AuthorRepository;
import by.givebook.services.AuthorService;
import by.givebook.services.impl.superServices.SimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by operb_000 on 01.03.2016.
 */
@Service
public class AuthorServiceImpl extends SimpleServiceImpl<Author, Long> implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public boolean add(String name) {
        try{
            Author author = new Author();
            author.setName(name);
            authorRepository.save(author);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean update(Long id, String name) {
        try {
            Author author = authorRepository.findOne(id);
            author.setName(name);
            authorRepository.save(author);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
