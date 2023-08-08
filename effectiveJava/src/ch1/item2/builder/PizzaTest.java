package ch1.item2.builder;

import static ch1.item2.builder.NyPizza.Size.*;
import static ch1.item2.builder.Pizza.Topping.*;
public class PizzaTest {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(HAM).addTopping(ONION).build();
        System.out.println(pizza);
    }
}
