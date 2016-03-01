package by.givebook.services.superServices;

import java.io.Serializable;
import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
public interface SimpleService<T, ID extends Serializable> {
    T get(ID id);
    List<T> getAll();
    boolean delete(ID id);
}
