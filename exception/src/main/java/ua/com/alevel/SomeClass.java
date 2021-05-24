package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SomeClass {

    public void test() {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer i = null;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = bufferedReader.readLine();
            System.out.println("s = " + s);
            i = Integer.parseInt(s);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
        } catch (RuntimeException e) {
            System.out.println("e = " + e.getMessage());
            System.out.println(e.getClass().getName());
            throw new CustomException(e.getMessage());
        } finally {
            System.out.println("SomeClass.test");
//            try {
//                bufferedReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        if (i != null)
        System.out.println("i = " + i);
    }
}
