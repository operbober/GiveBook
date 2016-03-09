package by.givebook.services;


import by.givebook.entities.IdEntity;
import by.givebook.services.impl.SimpleServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by operb_000 on 04.03.2016.
 */
public abstract class SimpleServiceFactory<E extends IdEntity> extends AbstractFactoryBean<SimpleServiceImpl<E>> implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    protected SimpleServiceImpl<E> createInstance() throws Exception {
        SimpleServiceImpl<E> instance = new SimpleServiceImpl<E>(){};
        applicationContext
                .getAutowireCapableBeanFactory()
                .autowireBean(instance);
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return new SimpleServiceImpl<E>(){}.getClass();
    }

}
