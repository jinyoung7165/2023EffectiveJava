package ch1.item4.streamfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class CarFactory {
    public static List<Car> create(Supplier<? extends Car> generator, int count) {
        List<Car> list = new ArrayList<>();
        for (int i=0; i<count; i++) { // count만큼 객체 생성 -> get으로 가져올 수 있음: Supplier 특성상
            list.add(generator.get());
        }
        return list;
    }

}
