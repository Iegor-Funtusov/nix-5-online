package ua.com.alevel.service;

import ua.com.alevel.dao.UserDao;
import ua.com.alevel.dao.UserDaoImpl;
import ua.com.alevel.entity.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void create(User user) {
        userDao.create(user);
    }
}
