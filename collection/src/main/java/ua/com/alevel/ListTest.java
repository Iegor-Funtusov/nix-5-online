package ua.com.alevel;

import java.util.*;

import static ua.com.alevel.CollectionMain.SIZE;

public class ListTest {

    public void test() {




        String s = "res";
        GenericClass<String> genericClass = new GenericClass<>();
        genericClass.setRes(s);
        genericClass.setResGen(s);

        String res = (String) genericClass.getRes();
        String res1 = genericClass.getResGen();

        Integer integer;
        int i;

        List<Number> numbers = new ArrayList<>();
        numbers.add((byte) 1);
        numbers.add(1);
        numbers.add(1L);


        Collection<Object> collection;      Map map;

        List list;   Queue queue;   Set set;

        ArrayList<Object> arrayList;

        // add O(1)
        // get O(1)
        // set O(1)
        // remove O(n)

        LinkedList<String> linkedList;

        // add O(1)
        // get O(n)
        // set O(n)
        // remove O(n)

        // add

        List<Integer> integerArrayList = new ArrayList<>();
        List<Integer> integerLinkedList = new LinkedList<>();
        Collections.sort(integerLinkedList);

        System.out.println("ADD");
        long start = System.currentTimeMillis();

        for (int j = 0; j < SIZE; j++) {
            integerArrayList.add(j);
        }

        long end = System.currentTimeMillis() - start;
        System.out.println("end ArrayList = " + end);

        start = System.currentTimeMillis();
        for (int j = 0; j < SIZE; j++) {
            integerLinkedList.add(j);
        }

        end = System.currentTimeMillis() - start;
        System.out.println("end LinkedList = " + end);

        System.out.println("GET");

        start = System.currentTimeMillis();

        for (int j = 0; j < SIZE; j++) {
            integerArrayList.get(j);
        }

        end = System.currentTimeMillis() - start;
        System.out.println("end ArrayList = " + end);

        start = System.currentTimeMillis();
        for (int j = 0; j < SIZE; j++) {
            integerLinkedList.get(j);
        }

        end = System.currentTimeMillis() - start;
        System.out.println("end LinkedList = " + end);

        System.out.println("DELETE");

        start = System.currentTimeMillis();

        Iterator<Integer> integerIterator = integerArrayList.listIterator();
        while (integerIterator.hasNext()) {
            integerIterator.next();
            integerIterator.remove();
        }

        end = System.currentTimeMillis() - start;
        System.out.println("end ArrayList = " + end);

        start = System.currentTimeMillis();
        integerIterator = integerLinkedList.listIterator();
        while (integerIterator.hasNext()) {
            integerIterator.next();
            integerIterator.remove();
        }

        end = System.currentTimeMillis() - start;
        System.out.println("end LinkedList = " + end);

    }
}
