package ua.com.alevel.service;

import ua.com.alevel.config.annotation.Autowired;
import ua.com.alevel.config.annotation.Service;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User find(long id) {
        return userDao.find(id);
    }

    @Override
    public List<User> find() {
        return userDao.find();
    }
}
