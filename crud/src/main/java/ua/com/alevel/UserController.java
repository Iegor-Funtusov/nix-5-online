package ua.com.alevel;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.UUID;

public class UserController {

    private final UserService userService = new UserService();

    @SneakyThrows
    public void readConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("hello");
        System.out.println("please, enter input");
        String input;
        while ((input = reader.readLine()) != null) {
            switch (input) {
                case "0" : {
                    System.exit(0);
                } break;
                case "1" : {
                    create(reader);
                } break;
                case "2" : {
                    readAll(reader);
                } break;
            }
        }
    }

    @SneakyThrows
    private void create(BufferedReader reader) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        System.out.println("create");
        System.out.println("enter name: ...");
        String name = reader.readLine();
        user.setName(name);
        System.out.println("enter age: ...");
        String age = reader.readLine();
        user.setAge(Integer.parseInt(age));
        userService.add(user);
    }

    private void readAll(BufferedReader reader) {
        System.out.println("read all");
        System.out.println(userService.findAll());
    }
}
