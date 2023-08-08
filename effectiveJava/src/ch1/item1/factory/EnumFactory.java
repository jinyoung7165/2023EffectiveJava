package ch1.item1.factory;

public enum EnumFactory {
    INSTANCE;

    public void leave() {
        System.out.println("지금 나갈게");
    }

    public static void main(String[] args) {
        EnumFactory enumFactory = EnumFactory.INSTANCE;
        enumFactory.leave();
    }
}
