package ua.com.alevel.service;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = ObjectFactory.getInstance().getUserDao();

    @Override
    public void create(User user) {
        userDao.create(user);
    }
}
