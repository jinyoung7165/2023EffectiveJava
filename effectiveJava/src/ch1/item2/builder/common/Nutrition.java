package ch1.item2.builder.common;

import lombok.Data;

@Data
public class Nutrition { // final -> 생성자 주입 받을 것
    private final int calorie; // 필수
    private final int sodium; // 필수
    private final int protein;

    private Nutrition(Builder builder) {
        calorie = builder.calorie;
        sodium = builder.sodium;
        protein = builder.protein;
    }

    public static Builder builder(int calorie, int sodium) {
        return new Builder(calorie, sodium);
    }

    public static class Builder {
        private final int calorie; // 필수
        private final int sodium; // 필수
        private int protein; // optional -> final 아님

        public Builder(int calorie, int sodium) {
             this.calorie = calorie;
             this.sodium = sodium;
        }

        public Builder protein(int protein) {
            this.protein = protein;
            return this; // method chaining 위함 -> 속성 언제든 추가 가능
        }

        public Nutrition build() {
            return new Nutrition(this);
        }
    }
}
