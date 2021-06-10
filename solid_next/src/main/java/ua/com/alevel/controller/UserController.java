package ua.com.alevel.controller;

import ua.com.alevel.config.annotation.Autowired;
import ua.com.alevel.config.annotation.Service;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class UserController {

    @Autowired
    private UserService userService;

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findById(reader); break;
            case "5" : findAll(reader); break;
        }
    }

    private void create(BufferedReader reader) {
        System.out.println("UserController.create");
        System.out.println("userService = " + userService);
        try {
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your age");
            String ageString = reader.readLine();
            int age = Integer.parseInt(ageString);
            User user = new User();
            user.setAge(age);
            user.setName(name);
            userService.create(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("UserController.update");
    }

    private void delete(BufferedReader reader) {
        System.out.println("UserController.delete");
    }

    private void findById(BufferedReader reader) {
        System.out.println("UserController.findById");
    }

    private void findAll(BufferedReader reader) {
        System.out.println("UserController.findAll");
    }
}
