package ch1.item6.composition;


public class ColorPointFromComposition {
    // ColorPoint 합성 class를 직접 만들지 말고,
    // Color와 Point를 주입받아 속성으로 가지는
    // 위임 class 생성
    private final Point point;
    private final Color color;

    public ColorPointFromComposition(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) { // point, color 각각 비교 가능
        if (!(o instanceof ColorPointFromComposition)) return false;
        ColorPointFromComposition cp = (ColorPointFromComposition) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
