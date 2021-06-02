package ua.com.alevel;

import java.util.*;
import java.util.stream.Collectors;

public class SetClass {

    public void test() {

        Set<User> users = new HashSet<>();

        users.add(new User("www"));
        users.add(new User("qqq"));
        users.add(new User("aaa"));
        users.add(new User("rrr"));
        users.add(new User("eee"));
        users.add(new User("bbb"));

        System.out.println("users = " + users);

        Set<User> collect = users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("collect = " + collect);
//
//        users.forEach(System.out::println);
//
//        System.out.println("link");
//
//        users = new LinkedHashSet<>();
//        users.add(new User("qqq"));
//        users.add(new User("www"));
//        users.add(new User("eee"));
//        users.add(new User("rrr"));
//
//        users.forEach(System.out::println);

//        System.out.println("tree set");
//
//        Set<User> users = new TreeSet<>();
//        users.add(new User("qqq", 5));
//        users.add(new User("qqq", 3));
//        users.add(new User("www", 2));
//        users.add(new User("eee", 3));
//        users.add(new User("rrr", 4));
//        users.add(new User("qqq", 1));
//
//        users.forEach(System.out::println);
    }
}
