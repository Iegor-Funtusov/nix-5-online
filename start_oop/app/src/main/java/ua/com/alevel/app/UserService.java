package ua.com.alevel.app;

import ua.com.alevel.lib.CrudProcess;
import ua.com.alevel.lib.CrudProcessFactory;
import ua.com.alevel.lib.DefaultCrudProcess;

import java.util.Collection;

// SOLID
public class UserService {

    CrudProcess<User> userCrudProcess = CrudProcessFactory.getInstance().getCrudProcess();
//    CrudProcess<User> userCrudProcess = new DefaultCrudProcess<>(); // evil

    public void create(User user) {
        userCrudProcess.create(user);
    }

    public void update(User user) {
        userCrudProcess.update(user);
    }

    public void delete(String id) {
        userCrudProcess.delete(id);
    }

    public Collection<User> read() {
        return userCrudProcess.read();
    }

    public User read(String id) {
        return userCrudProcess.read(id);
    }
}
