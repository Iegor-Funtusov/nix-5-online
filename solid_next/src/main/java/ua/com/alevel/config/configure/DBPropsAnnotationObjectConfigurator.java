package ua.com.alevel.config.configure;

import ua.com.alevel.config.ApplicationContext;
import ua.com.alevel.config.annotation.DBProps;
import ua.com.alevel.util.ResourceUtil;

import java.lang.reflect.Field;
import java.util.Map;

public class DBPropsAnnotationObjectConfigurator implements ObjectConfigurator {

    private final Map<String, String> map;

    public DBPropsAnnotationObjectConfigurator() {
        this.map = ResourceUtil.getResource("db.properties");
    }

    @Override
    public void configure(Object o, ApplicationContext context) {
        Class<?> implClass = o.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            DBProps annotation = field.getAnnotation(DBProps.class);
            if (annotation != null) {
                String value = annotation.value();
                field.setAccessible(true);
                try {
                    field.set(o, map.get(value));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("something problem from initial field: " + e.getMessage());
                }
            }
        }
    }
}
