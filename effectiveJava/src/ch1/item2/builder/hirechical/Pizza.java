package ch1.item2.builder.hirechical;
import java.util.*;
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION};
    final Set<Topping> toppings;
    // 모든 type의 Builder 구현체 받아 처리 (builder가 가진 toppings을 복사함)
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
    abstract static class Builder<T extends Builder<T>> {
        // simulated self-type: 자식 class에서 구현한 method가 자식 class type 반환하게 함
        // method chaining 위함
        // Builder (자식) 구현체 type T = Builder<T> type의 하위 class
        // Builder class의 하위 class에서도 이 builder pattern 이용하게 함
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class); // 빈 EnumSet 초기화
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self(); // chaining 가능하게 함
        }

        abstract Pizza build(); // 추상 메소드 build 구현하라
        protected abstract T self(); // 추상 메소드 self 구현하라 -> this return해야 함
    }

}
