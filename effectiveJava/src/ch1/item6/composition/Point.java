package ch1.item6.composition;

import lombok.Data;

import java.util.Objects;

@Data
public class Point {
    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 같은 참조값
        if (!(o instanceof Point)) return false; // Point 또는 자식 class가 아니면 false
        Point point = (Point) o; // 자식 클래스 -> Point로 업캐스팅
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
