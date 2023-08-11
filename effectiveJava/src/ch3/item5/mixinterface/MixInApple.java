package ch3.item5.mixinterface;

public class MixInApple implements Food, Comparable<MixInApple> {
    private final String name;
    private final long price;

    public MixInApple(String name, long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(MixInApple o) {
        return Long.compare(price, o.price);
    }
}