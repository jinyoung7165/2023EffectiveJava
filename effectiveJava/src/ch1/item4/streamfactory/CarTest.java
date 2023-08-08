package ch1.item4.streamfactory;

import java.util.List;

public abstract class CarTest {
    private CarTest() {}
    public static void main(String[] args) {
        List<Car> cars = CarFactory.create(() -> Car.of("k5"), 10);
        System.out.println("cars = " + cars);
    }
}
