package ua.com.alevel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public void createStream() {
        // 1
        List<String> strings = Arrays.asList("1", "2", "3");

        strings.removeIf(s -> s.equals("444"));

        Stream<String> stringStream = strings.stream();

        // 2
        stringStream = Stream.of("1", "2", "3");

        // 3
        String[] strings1 = { "1", "2", "3" };
        stringStream = Arrays.stream(strings1);

//        strings.add("4");
//        strings.set(0, "-1");
//        strings = List.of("1", "2", "3");
//        strings.set(0, "-1");
    }

    public void streamProcess() {
        List<String> strings = Arrays.asList("1", "11", "2", "34", "3", "0", "34", "4", "5", "5");
        List<String> strings1 = new ArrayList<>();
        for (String string : strings) {
            if (!string.equals("4")) {
                strings1.add(string);
            }
        }
        System.out.println("strings1 = " + strings1);

        strings1 = strings
                .stream()
                .filter(s -> !s.equals("4"))
                .collect(Collectors.toList());

        System.out.println("strings1 = " + strings1);

        strings1 = new ArrayList<>();
        for (int i = 1; i < strings.size(); i++) {
            if (!strings.get(i).equals("4")) {
                strings1.add(strings.get(i));
            }
        }
        System.out.println("strings1 = " + strings1);

        strings1 = strings
                .stream()
                .skip(1)
                .filter(s -> !s.equals("4"))
                .collect(Collectors.toList());

        System.out.println("strings1 = " + strings1);

        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i < strings.size(); i++) {
            if (!strings.get(i).equals("4")) {
                integers.add(Integer.parseInt(strings.get(i)));
            }
        }
        System.out.println("integers = " + integers);

        integers = strings
                .stream()
                .skip(1)
                .filter(s -> !s.equals("4"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        System.out.println("integers = " + integers);

        integers = strings
                .stream()
                .skip(1)
                .distinct()
                .filter(s -> !s.equals("4"))
                .map(s -> Integer.parseInt(s))
                .sorted()
                .collect(Collectors.toList());

        boolean b = false;
        for (Integer integer : integers) {
            if (integer % 2 == 0) {
                b = true;
                break;
            }
        }
        System.out.println("b = " + b);

        b = integers.stream().allMatch(i -> i % 2 == 0);
        System.out.println("b = " + b);

        System.out.println("strings = " + strings);
        System.out.println("integers = " + integers);

        int sum = strings
                .stream()
                .skip(1)
                .distinct()
                .filter(s -> !s.equals("4"))
                .mapToInt(s -> Integer.parseInt(s))
                .sum();

        System.out.println("sum = " + sum);

        int first = strings
                .stream()
                .skip(1)
                .distinct()
                .filter(s -> !s.equals("4"))
                .map(s -> Integer.parseInt(s))
                .sorted()
                .findFirst()
                .get();

        System.out.println("first = " + first);

        long count = strings
                .stream()
                .skip(1)
                .distinct()
                .filter(s -> !s.equals("4"))
                .map(s -> Integer.parseInt(s))
                .count();

        System.out.println("count = " + count);

        int max = strings
                .stream()
                .skip(1)
                .distinct()
                .filter(s -> !s.equals("4"))
                .map(Integer::parseInt)
                .max(Comparator.naturalOrder())
                .get();

        System.out.println("max = " + max);

        int min = strings
                .stream()
                .skip(1)
                .distinct()
                .filter(s -> !s.equals("4"))
                .map(Integer::parseInt)
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("min = " + min);

        OptionalDouble average = strings
                .stream()
                .skip(1)
                .distinct()
                .filter(s -> !s.equals("4"))
                .mapToInt(Integer::parseInt)
                .average();

        System.out.println("average = " + (int) average.getAsDouble());
    }
}
