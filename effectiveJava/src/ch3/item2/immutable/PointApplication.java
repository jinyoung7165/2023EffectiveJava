package ch3.item2.immutable;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PointApplication { // 불변 class -> 병렬 처리에서 어떻게 활용할까
    private static Point point = Point.ZERO; // 이미 생성된 객체 이용. (새로 생성해도 무방)
    // static 참조 변수 -> 스레드가 자원 공유하게 함

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("future1 point = " + point);
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            point = point.move(3, 4);
            // Lambda 식에서 외부 변수는, Effectively final 변수만 참조 가능
            // 값 바꾸는 대신, 새 객체 생성해 참조하게 함
            // 원래 객체의 값은 불변 -> Lambda 식에서 사용 가능
            // 스레드 2부터 실행되면, 스레드 1의 참조 변수도 새로운 객체를 가리킴
            System.out.println("future1 point = " + point);
        });
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2);
        allOf.get();
    }

    private static class Point {
        public static final Point ZERO = new Point(0, 0);
        public static final Point ONE = new Point(1, 0);

        private final double x;
        private final double y;

        private Point(double x, double y) { // private 생성자->확장 방지
            this.x = x;
            this.y = y;
        }

        public static Point valueOf(double x, double y) {
            if (x == 0 && y == 0) return ZERO; // CACHING
            if (x == 1 && y == 0) return ONE;
            return new Point(x, y);
        }

        public Point move(double x, double y) { // 내용 수정하지 말고, 새로운 불변 객체 생성해 return
            return new Point(this.x + x, this.y + y);
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }
}