package ua.com.alevel.config;

import org.reflections.Reflections;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObjectFactory {

    private static ObjectFactory instance;
    private static final String ROOT_PACKAGE = "ua.com.alevel";

    private final Set<Class<? extends UserDao>> setDao;
    private final Set<Class<? extends UserService>> setService;

    private ObjectFactory() {
        Reflections reflections = new Reflections(ROOT_PACKAGE);
        setDao = reflections.getSubTypesOf(UserDao.class);
        setService = reflections.getSubTypesOf(UserService.class);
    }

    public static ObjectFactory getInstance() {
        if (instance == null) {
            instance = new ObjectFactory();
        }
        return instance;
    }

    public UserDao getUserDao() {
        if (setDao.isEmpty()) {
            throw new RuntimeException("user dao is not implemented");
        }
        for (Class<? extends UserDao> aClass : setDao) {
            try {
                return aClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("user dao is not implemented");
    }

    public UserService getUserService() {
        if (setService.isEmpty()) {
            throw new RuntimeException("user service is not implemented");
        }
        for (Class<? extends UserService> aClass : setService) {
            try {
                return aClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("user service is not implemented");
    }
}
