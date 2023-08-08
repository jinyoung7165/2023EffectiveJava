package ch2.item2.builder;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE};
    private final Size size;

    private NyPizza(Builder builder) {
        super(builder); // Pizza Abstract class의 생성자: builder로부터 topping 주입받음
        size = builder.size; // builder로부터 size 주입
    }

    @Override
    public String toString() {
        return toppings + "로 토핑한 뉴욕 피자";
    }

    public static class Builder extends Pizza.Builder<Builder> {
        // 부모의 class 상속하되, return type: 자신(자식 class) -> method chaining 가능
        private final Size size;
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() { // builder를 주입받아 객체 생성
            return new NyPizza(this);
        }
        @Override
        protected Builder self() {
            return this;
        } // chaining을 위해 this반환

    }
}
