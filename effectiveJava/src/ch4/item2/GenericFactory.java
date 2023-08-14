package ch4.item2;

import ch4.item2.functional.ApplyFunction;
import lombok.Data;

import java.util.*;

@Data
public class GenericFactory implements SingletonBase {
    // 불변 객체(항등함수) 공유하고자 함
    private static ApplyFunction<Object> IDENTITY_FUNCTION = arg -> {
        System.out.println("arg = " + arg);
        return arg;
    }; // 매개변수 출력만 해주는 함수형 인터페이스

    // static lambda function의 Generic Type 지정 : 여러 data type에 따라 객체 재사용 가능
    // Generic Singleton Factory -> Object type만 변형(Downcasting)해서 재사용
    @SuppressWarnings("unchecked")
    public static <T> ApplyFunction<T> identityFunction() {
        return (ApplyFunction<T>) IDENTITY_FUNCTION;
    }

    // Set<? extends E> -> E의 하위 class원소들도 받아서 union 가능
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // <E extends Comparable<E>> -> E type에 대한 가정 추가
    // Comparable<E>을 구현했을 것이다
    // -> compareTo 사용 가능
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty()) return Optional.empty();

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }
        return Optional.of(result);
    }

    @Override
    public void print() {
        System.out.println("Generic Singleton Factory");
    }
}
