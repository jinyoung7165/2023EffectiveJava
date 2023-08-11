package ch3.item5.mixinterface;

public interface FoodComparable extends Comparable<FoodComparable> {
    // Comparable 상속 =>
    // interface 구현체는 모두 Comparable의 compareTo 메소드를 구현해야 함
    String getName();
}
