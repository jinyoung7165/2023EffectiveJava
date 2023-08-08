package ch1.item2.builder.hirechical;

import static ch1.item2.builder.hirechical.NyPizza.Size.*;
import static ch1.item2.builder.hirechical.Pizza.Topping.*;
public abstract class PizzaTest {
    private PizzaTest() {}
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(HAM).addTopping(ONION).build();
        System.out.println(pizza);
    }
}
