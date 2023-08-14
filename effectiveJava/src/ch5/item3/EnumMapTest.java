package ch5.item3;

import ch5.item2.Plant;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toSet;

public abstract class EnumMapTest {
    // Enum의 ordinal int value ->
    // 그대로 배열/Map의 idx로 사용하지 마라
    // Enum의 ordinal Value는 선언 위치 기반으로 idx 반환하기 때문에
    // compiler는 배열/Map에서 각 인덱스의 의미 모름 -> 출력결과에 직접 label 달아야 함
    // idx 정수는 Type 안전하지 않음 <- 정확한 정수 사용한다는 것을 개발자가 보증해야 함
    public static void main(String[] args) {
        Plant[] GARDEN = new Plant[16];
        Map<Plant.LifeCycle, Set<Plant>> plantByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantByLifeCycle.put(lc, new HashSet<>());
        }

        for (Plant p : GARDEN) {
            plantByLifeCycle.get(p.lifeCycle).add(p);
        }

        System.out.println(plantByLifeCycle);

        System.out.println(stream(GARDEN)
                .collect(Collectors.groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class),
                        toSet())));
    }
}
