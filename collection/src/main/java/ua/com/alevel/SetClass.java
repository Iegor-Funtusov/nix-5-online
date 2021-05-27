package ua.com.alevel;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetClass {

    public void test() {

        Set<User> users = new HashSet<>();
        users.add(new User("qqq"));
        users.add(new User("www"));
        users.add(new User("eee"));
        users.add(new User("rrr"));

        users.forEach(System.out::println);

        System.out.println("link");

        users = new LinkedHashSet<>();
        users.add(new User("qqq"));
        users.add(new User("www"));
        users.add(new User("eee"));
        users.add(new User("rrr"));

        users.forEach(System.out::println);

        System.out.println("tree set");

        users = new TreeSet<>();
        users.add(new User("qqq"));
        users.add(new User("www"));
        users.add(new User("eee"));
        users.add(new User("rrr"));

        users.forEach(System.out::println);
    }
}
