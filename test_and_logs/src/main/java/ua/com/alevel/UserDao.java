package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {

    private List<User> list = new ArrayList<>();

    public void create(User user) {
        user.setId(list.size() + 1);
        list.add(user);
    }

    public void delete(Integer id) {
        list.removeIf(user -> user.getId().equals(id));
    }

    public List<User> find() {
        return list;
    }

    public User find(Integer id) {
        return list.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public List<User> find(String name) {
        return list.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
    }

    public User findByEmail(String email) {
        return list.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }
}
