package ch5.item2;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>> m =
                Stream.of(values()).collect(
                        groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class),
                        toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase.class))));
                        // from을 기준으로 Transition 원소 묶음, map 구현체 지정, 값 지정: toMap=Map을 VALUE로 하겠다
                        // VALUE가 될 MAP의 KEY: to, VALUE: Transition자체, mergeFunction: 중복 거름, 특정 map 구현체 지정
        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }
}
