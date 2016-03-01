package by.givebook.services.impl.superServices;

import by.givebook.services.superServices.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
public class SimpleServiceImpl<T, ID extends Serializable> implements SimpleService<T,ID> {
    @Autowired
    CrudRepository<T,ID> entityes;


    @Override
    public T get(ID id) {
        return entityes.findOne(id);
    }

    @Override
    public List<T> getAll() {
        List<T> allentityes = new ArrayList<>();
        entityes.findAll().forEach(allentityes::add);
        return allentityes;
    }

    @Override
    public boolean delete(ID id) {
        try{
            entityes.delete(id);
            return true;
        }
        catch(Exception e){
           return false;
        }
    }
}
