package ch1.item6.composition;

import java.util.Objects;

public class ColorPoint extends Point {
    private Color color;

    public ColorPoint(long x, long y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorPoint)) return false;
        if (!super.equals(o)) return false;

    }
}
