package ch1.item2.builder.hirechical;
import java.util.*;
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION};
    final Set<Topping> toppings;
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // 아이템 50 참조
    }
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();
        protected abstract T self();
    }

}
