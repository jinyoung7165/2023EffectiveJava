package ch5.item2;

import java.util.Set;

public class EnumSetExample {
    public enum Style {BOLD, ITALIC, UNDERLINE};

    public void applyStyles(Set<Style> styleSet) {
        // Enum을 Key로 받는 Set
        // -> bit 상수 field보다 낫다
    }

    // text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
}
