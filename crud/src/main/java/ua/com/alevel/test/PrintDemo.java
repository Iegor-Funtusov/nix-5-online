package ua.com.alevel.test;

import org.apache.commons.lang3.StringUtils;

public class PrintDemo {

    public void print() {
        String s = "Hello";
        System.out.println(s);
        s = StringUtils.upperCase(s);
        System.out.println(s);
    }
}
