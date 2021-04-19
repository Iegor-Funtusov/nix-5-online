package ua.com.alevel;

import java.util.List;

public class UserService {

    private DB db = new DB();

    public void add(User user) {
        if (db.isExistById(user.getId())) {
            System.out.println("user exist");
        } else {
            db.add(user);
        }
    }

    public List<User> findAll() {
        return db.findAll();
    }
}
