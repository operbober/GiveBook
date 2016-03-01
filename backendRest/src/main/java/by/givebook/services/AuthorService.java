package by.givebook.services;

import by.givebook.entities.Author;
import by.givebook.services.superServices.SimpleService;

/**
 * Created by operb_000 on 01.03.2016.
 */
public interface AuthorService extends SimpleService<Author, Long> {
    boolean add(String name);
    boolean update(Long id, String name);
}
