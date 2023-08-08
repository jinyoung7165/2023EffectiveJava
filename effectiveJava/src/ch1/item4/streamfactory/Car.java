package ch1.item4.streamfactory;

import lombok.Data;

import java.util.Objects;

@Data
public class Car {
    private static Long sequence = 0L;
    private String serial;
    private String name;

    private Car(String serial, String name) {
        this.serial = serial;
        this.name = name;
    }

    private static String generateSerial(Long id) {
        return "Racing" + Objects.hashCode(id);
    }

    public static Car of(String name) {
        String generatedSerial = generateSerial(++sequence);
        return new Car(generatedSerial, name);
    }

    public void move() {
        System.out.println("2배 속도 전진");
    }

}
