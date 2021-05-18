package ua.com.alevel;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService {

//    private static final Logger logger = LogManager.getLogger(UserService.class);
//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final Logger loggerInfo = LoggerFactory.getLogger("info");
    private static final Logger loggerWarn = LoggerFactory.getLogger("warn");
    private static final Logger loggerError = LoggerFactory.getLogger("error");

    private UserDao userDao = new UserDao();

//    public void create(User user) {
//        logger.info("Start create user: " + user.getName());
//        if (user.getEmail() != null) {
//            User exist = userDao.findByEmail(user.getEmail());
//            if (exist != null) {
//                throw new RuntimeException("");
//            }
//            userDao.create(user);
//        } else {
//            throw new RuntimeException("");
//        }
//        logger.info("End create user");
//    }

    public void create(User user) {
        loggerInfo.info("Start create user: " + user.getName());
        if (!existByEmail(user)) {
            userDao.create(user);
        }
        loggerInfo.info("End create user");
    }

    private boolean existByEmail(User user) {
        if (user.getEmail() != null) {
            User exist = userDao.findByEmail(user.getEmail());
            if (exist != null) {
                loggerError.error("this user is already exist");
            }
            return false;
        } else {
            loggerError.error("email can't be empty");
        }
        return true;
    }

    public void delete(Integer id) {
        loggerWarn.warn("Start remove user by id: " + id);
        userDao.delete(id);
        loggerWarn.warn("End remove user");
    }

    public List<User> find() {
        return userDao.find();
    }

    public List<User> find(String name) {
        return userDao.find(name);
    }

    public User find(Integer id) {
        return userDao.find(id);
    }
}
