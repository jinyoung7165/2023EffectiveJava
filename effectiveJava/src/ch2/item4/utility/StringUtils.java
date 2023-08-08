package ch2.item4.utility;

public abstract class StringUtils {
    // instance화 막기 위한 생성자 정의
    // 기본 생성자 방지 private으로 제한
    private StringUtils() {
        throw new AssertionError();
    }

    public static void print(String msg) {
        System.out.println(msg);
    }
}
