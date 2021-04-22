package ua.com.alevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BaseMain {

    private static String STR;

    static {
        STR = "gfuhdklsfghds";
    }

    private static void test(Integer[] ... ints) {
        for (Integer[] anInt : ints) {
            System.out.println("anInt = " + Arrays.toString(anInt));
        }
    }

    public static void main(String[] args) {

        test(
                new Integer[]{1, 9, 9},
                new Integer[]{8, 4, 0},
                new Integer[]{0, 3, 5}
        );

//        System.out.println("args = " + args[0]);
//        primitive();
//        binary();
//        logic();
//        circle();
//        event();
    }

    private static void array() {
        int[] ints = new int[3];
        ints[2] = 6;
        int[] intss = { 0, 1, 2 };
    }

    private static void event() {
        int a = (10 < 6) ? 7 : 8;
        System.out.println("a = " + a);

        a = 3;

        if (a == 0) {
            System.out.println("a == 0");
        } else if (a == 1) {
            System.out.println("a == 1");
        } else if (a == 2) {
            System.out.println("a == 2");
        } else {
            System.out.println("else");
        }

        switch (a) {
            case 0 : System.out.println("a = " + a); break;
            case 1 : System.out.println("a = " + a); break;
            case 2 : System.out.println("a = " + a); break;
            case 3 : System.out.println("a = " + a); break;
            default:
                System.out.println("default");
        }
    }

    private static void circle() {
        for (int i = 0; i < 10; i++) { }

        int i = 0;

        while (i < 10) {
            ++i;
        }

        do {
            System.out.println("do");
        } while (false);

        for (Character character : "bla".toCharArray()) {
            System.out.println("character = " + character);
        }

        Stream.of( "bla".toCharArray()).map(Objects::toString).forEach(chars -> {
            System.out.println("chars = " + chars);
        });

        Stream.of( "bla".toCharArray()).forEach(System.out::println);

        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                if (k == 3) {
                    break;
                }
                if (k == 4) {
                    continue;
                }
                if (k == 5) {
                    return;
                }
            }
        }
    }

    private static void logic() {
        // AND
        byte a = (byte) 56;
        byte b = (byte) 17;
        byte c = (byte) (a & b);
        System.out.println("c = " + c);

        print(a, b, c);

        // OR
        a = (byte) 56;
        b = (byte) 17;
        c = (byte) (a | b);
        System.out.println("c = " + c);

        print(a, b, c);

        // XOR
        a = (byte) 56;
        b = (byte) 17;
        c = (byte) (a ^ b);
        System.out.println("c = " + c);

        print(a, b, c);

        a = (byte) (~(a) + 1);
        System.out.println("a = " + a);
    }

    private static void binary() {
        int a = 24;
        System.out.println("a = " + a * 2);
        int b  = a << 1;
        System.out.println("b = " + b);
    }

    private static void primitive() {
        byte a = Byte.MAX_VALUE;
        byte b = (byte) 1;
        byte c =  (byte) (a + b);

        System.out.println("c = " + c);

        print(a, b, c);

        short s = (short) 128;
        byte cast = (byte) s;

        System.out.println("cast = " + cast);
    }

    private static void print(byte a, byte b, byte c) {
        String aa = ConvertUtil.convertNumberToBinary(a, Byte.class);
        String bb = ConvertUtil.convertNumberToBinary(b, Byte.class);
        String cc = ConvertUtil.convertNumberToBinary(c, Byte.class);

        System.out.println("aa = " + aa);
        System.out.println("bb = " + bb);
        System.out.println("cc = " + cc);
    }
}
