package ua.com.alevel;

import java.util.HashMap;
import java.util.Map;

public class StringClass {

    final class A {}

    public static class B {}

    private interface AA {}

    private enum AAA {}

    public void test() {
        final int i;
    }

    void test1() {}
    void test1(int i) { }

    StringClass() {}
    StringClass(int i) {}

    synchronized

    public static void main(String[] args) {
        new StringClass();
        new StringClass(7);

        System.currentTimeMillis();

        System.out.println("StringClass.main");

        String s = "  he1   llo     2";

        s = "hello";
        s = s.substring(1, 3);
        System.out.println("s = " + s);


//        char c = s.charAt(4);
//        System.out.println("c = " + c);
        s = s.trim();
        System.out.println("s = " + s);


        String[] strings = s.replaceAll("[0-9]", "").split("\\s+");

        System.out.println("strings = " + strings.length);
        for (String string : strings) {
            System.out.println("string = " + string);
        }

        String regex = "[0-9]";
        s= s.replaceAll(regex, "");
        System.out.println("s = " + s);
        s = s.replace('h', 't');
        System.out.println("s = " + s);
        StringBuilder stringBuilder = new StringBuilder(s);
        s = stringBuilder.reverse().toString();
        System.out.println("s = " + s);

        s= s.toLowerCase();
        System.out.println("s = " + s);
        s= s.toUpperCase();
        System.out.println("s = " + s);

        char[] chars = s.toCharArray();

        s = "222";
        int length = s.length();

        final Map<String, String> map = new HashMap<>();

        StringBuilder sql = new StringBuilder("select u from User u");

        map.forEach((key, value) -> {
            if (map.get(key).equals("sort")) {
                sql.append("where ...");
            }
        });
    }
}
