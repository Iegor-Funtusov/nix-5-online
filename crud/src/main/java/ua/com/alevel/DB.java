package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class DB {

    private final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public boolean isExistById(String id) {
        return this.users.stream().anyMatch(user -> user.getId().equals(id));
    }

    public List<User> findAll() {
        return this.users;
    }
}
