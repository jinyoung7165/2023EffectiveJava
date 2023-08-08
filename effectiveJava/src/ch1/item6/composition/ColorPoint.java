package ch1.item6.composition;

import java.util.Objects;

public class ColorPoint extends Point {
    private Color color;

    public ColorPoint(long x, long y, Color color) { // Point 생성 + Color 필드까지 주입
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorPoint)) return false; // ColorPoint 혹은 자식 class가 아님 false
        if (!super.equals(o)) return false; // point만 비교했는데, 다르면 false
        ColorPoint that = (ColorPoint) o;
        return color == that.color; // color까지 비교
    }

    @Override
    public int hashCode() { // 좌표 + color까지 hash에 넣음
        return Objects.hash(super.hashCode(), color);
    }
}
