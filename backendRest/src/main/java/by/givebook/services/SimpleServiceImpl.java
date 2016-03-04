package by.givebook.services;

import by.givebook.entities.IdEntity;
import by.givebook.repositories.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
public abstract class SimpleServiceImpl<T extends IdEntity>
        implements SimpleService<T> {

    @Autowired
    SimpleRepository<T> entitiesRepository;

    @Override
    public T get(Long id) {
        return entitiesRepository.findOne(id);
    }

    @Override
    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        entitiesRepository.findAll().forEach(entities::add);
        return entities;
    }

    @Override
    public boolean delete(Long id) {
        try{
            entitiesRepository.delete(id);
            return true;
        }
        catch(Exception e){
           return false;
        }
    }

    @Override
    public boolean save(T entity) {
        try{
            entitiesRepository.save(entity);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
