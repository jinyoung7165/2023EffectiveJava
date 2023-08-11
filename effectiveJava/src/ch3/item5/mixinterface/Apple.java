package ch3.item5.mixinterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Apple implements FoodComparable {
    private final String name;
    private final long price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(FoodComparable o) {
        // price는 Apple에만 있는 속성이므로 downcasting 필요
        return Long.compare(price, ((Apple)o).price);
    }
}
