package ua.com.alevel;

import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoTest {

    private static UserService userDao = new UserService();

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setEmail("email" + i);
            userDao.create(user);
        }
        Assertions.assertTrue(userDao.find().size() != 0);
    }

    @Test
    @Order(1)
    public void create() {
        User user = new User();
        user.setName("test");
        user.setEmail("email");
        userDao.create(user);

        List<User> users = userDao.find("test");
        Assertions.assertTrue(users.size() != 0);
    }

    @Test
    @Order(2)
    public void findAll() {
        List<User> users = userDao.find();
        Assertions.assertTrue(users.size() != 0);
    }

    @Test
    @Order(3)
    public void findAllByTestName() {
        List<User> users = userDao.find("test");
        Assertions.assertEquals(1, users.size());
    }

    @Test
    @Order(4)
    public void findById() {
        User user = userDao.find(1);
        Assertions.assertNotNull(user);
    }

    @Test
    @Order(5)
    public void removeById() {
        userDao.delete(1);
        User user = userDao.find(1);
        Assertions.assertNull(user);
    }
}
