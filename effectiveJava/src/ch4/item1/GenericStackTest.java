package ch4.item1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class GenericStackTest {
    public static void main(String[] args) {
        Stack<String> stackStr = new GenericStack<>();
        Stack<Double> stackDouble = new GenericStack<>();

        String str = "Hello";
        for (int i=0; i<str.length(); i++) {
            stackStr.push(str.charAt(i)+"");
            stackDouble.push(i+10D);
        }
        while (!stackStr.isEmpty()) {
            System.out.println(stackStr.pop().toUpperCase());
        }
        System.out.println();
        while (!stackDouble.isEmpty()) {
            System.out.println(stackDouble.pop());
        }

        Stack<Number> stackNumber = new GenericStack<>();
        List<Integer> integers = Arrays.asList(1,2,3,4,5);

        stackNumber.pushAll(integers);

        Collection<Object> objects = new ArrayList<>();
        stackNumber.popAll(objects);

        System.out.println("objects = " + objects);

    }
}
