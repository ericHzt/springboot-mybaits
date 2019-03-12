package com.example.Configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;

    }

    public ApplicationContext getApplicationContext(){
        return this.context;
    }

    public Object getBeans(String beanName){
        return context.getBean(beanName);
    }

    public <T> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }

    public <T> T getBean(String name,Class<T> clazz){
        return context.getBean(name,clazz);
    }
}
