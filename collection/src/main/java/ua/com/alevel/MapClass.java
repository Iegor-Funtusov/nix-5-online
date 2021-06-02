package ua.com.alevel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapClass {

    public void test() {
        Map<String, User> userMap = new ConcurrentHashMap<>();
        Map<String, User> userMap1 = Collections.synchronizedMap(userMap);

        userMap.put(UUID.randomUUID().toString(), new User("1"));
        userMap.put(UUID.randomUUID().toString(), new User("2"));
        userMap.put(UUID.randomUUID().toString(), new User("3"));
        userMap.put(UUID.randomUUID().toString(), new User("4"));
        userMap.put(UUID.randomUUID().toString(), new User("5"));

        userMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });

//        User user = userMap.get("1");
//        System.out.println("user = " + user);

//        Set<String> strings = userMap.keySet();
//        System.out.println("strings = " + strings);
//
//        Collection<User> users = userMap.values();
//        System.out.println("users = " + users);

        userMap = new TreeMap<>();
        userMap.put(UUID.randomUUID().toString(), new User("1"));
        userMap.put(UUID.randomUUID().toString(), new User("2"));
        userMap.put(UUID.randomUUID().toString(), new User("3"));
        userMap.put(UUID.randomUUID().toString(), new User("4"));
        userMap.put(UUID.randomUUID().toString(), new User("5"));
    }
}
