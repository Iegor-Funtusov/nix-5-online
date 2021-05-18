package ua.com.alevel;

public class TestAndLogsMain {

    public static void main(String[] args) {
        System.out.println("TestAndLogsMain.main");

        UserService userService = new UserService();
        for (int i = 0; i < 1_000; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setEmail("email" + i);
            userService.create(user);
        }

        userService.delete(3);
        userService.delete(7);

        User user = new User();
        user.setName("test" + 10);
        user.setEmail("email" + 10);
        userService.create(user);
    }
}
