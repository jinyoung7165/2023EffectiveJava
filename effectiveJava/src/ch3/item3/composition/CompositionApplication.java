package ch3.item3.composition;

import java.util.Arrays;
import java.util.HashSet;

public class CompositionApplication {
    public static void main(String[] args) {
        CompositionExtendedSet<String> set = new CompositionExtendedSet<>(new HashSet<>());
        set.addAll(Arrays.asList("hello", "java", "world"));
        System.out.println("set.getAddCount() = " + set.getAddCount());
    }
}
