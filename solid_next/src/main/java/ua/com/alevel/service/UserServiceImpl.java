package ua.com.alevel.service;

import ua.com.alevel.config.annotation.Autowired;
import ua.com.alevel.config.annotation.Service;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(User user) {
        userDao.create(user);
    }
}
