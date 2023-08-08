package ch2.item3.factory;

public class StaticFactory {
    private StaticFactory() {} // 외부 접근 차단 -> Singleton 관리
    private static final StaticFactory INSTANCE = new StaticFactory();
    public static StaticFactory getInstance() { return INSTANCE; }

    public void leave() {
        System.out.println("지금 나갈게");
    }

    public static void main(String[] args) {
        StaticFactory staticFactory = StaticFactory.getInstance();
        staticFactory.leave();
    }
}
