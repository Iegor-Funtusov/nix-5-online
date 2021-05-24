package ua.com.alevel;

import java.util.Random;

public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("start thread: " + thread.getName());
        Random random = new Random();
        int i = random.nextInt(2);
        System.out.println("i = " + i);
        try {
            System.out.println(10/ i);
        } catch (ArithmeticException e) {
            throw new ArithmeticException(e.getMessage());
            }
        System.out.println("finish: " + thread.getName());
    }
}
