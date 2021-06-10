package ua.com.alevel.config.configure;

import ua.com.alevel.config.ApplicationContext;
import ua.com.alevel.config.ObjectConfigurator;
import ua.com.alevel.config.annotation.Autowired;

import java.lang.reflect.Field;

public class AutowiredAnnotationObjectConfigurator implements ObjectConfigurator {

    @Override
    public void configure(Object o, ApplicationContext context) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Autowired.class)) {
                declaredField.setAccessible(true);
                Object impl = context.getObjectImpl(declaredField.getType());
                try {
                    declaredField.set(o, impl);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
