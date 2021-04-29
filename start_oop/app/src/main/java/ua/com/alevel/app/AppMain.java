package ua.com.alevel.app;

import java.util.ArrayList;
import java.util.Collection;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("AppMain.main");

        UserService userService = new UserService();

        User user = new User();
        user.setAge(20);
        user.setName("qq");
        userService.create(user);

        user = new User();
        user.setAge(25);
        user.setName("ww");
        userService.create(user);

        Collection<User> list = userService.read();
        list.forEach(System.out::println);

        for (User user1 : list) {
            if (user1.getName().equals("qq")) {
                user1.setName("qqq UPDATE");
                userService.update(user1);
            }
        }

        list = userService.read();
        list.forEach(System.out::println);

        CarService carService = new CarService();

        Car car = new Car();
        car.setName("BMW");
        carService.create(car);

        car = new Car();
        car.setName("AUDI");
        carService.create(car);

        carService.findAll().forEach(System.out::println);
    }
}
