package ch1.item2.builder.common;

public abstract class NutritionTest {

    public static void main(String[] args) {
        Nutrition nutrition = Nutrition.builder(3000, 30)
                .protein(20).build();
        System.out.println(nutrition);
    }

}
