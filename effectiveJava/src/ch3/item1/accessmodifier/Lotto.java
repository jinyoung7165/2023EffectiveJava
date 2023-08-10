package ch3.item1.accessmodifier;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    // 상수 필드 정의&제공 방법
    // 불변 기본형 상수 -> PUBLIC STATIC FINAL
    // 배열 -> private static final (public으로 제공 시, 참조값 전달해 수정 가능 문제)
    // 제공방법1 => public 불변 List로 제공
    // 제공방법2 => public static method로 복사본(clone) 제공
    public static final int ONE = 1;
    public static final int LOTTO_RANGE = 45;
    private static final LottoNumber[] LOTTO_NUMBERS;
    public static final List<LottoNumber> VALUES;
    // 불변 List 공유 가능 -> 굳이 private로 둘 이유는 없다

    static { // static 초기화 Block : Class가 처음 로드될 때, "단 1번만" 실행되는 CODE BLOCK
        // static 변수, 상수 필드 초기화하는 데 사용
        // Class Load -> 변수 기본 값 할당된 후에 실행
        LOTTO_NUMBERS = (LottoNumber[]) IntStream.range(ONE, LOTTO_RANGE)
                .mapToObj(LottoNumber::new).toArray(); // 객체를 담은 배열 생성해 LOTTO_NUMBERS로 참조(참조값은 변경 불가 final)
        VALUES = Collections.unmodifiableList(Arrays.asList(LOTTO_NUMBERS)); // 배열 내부 값도 바꿀 수 없게 불변 List 생성해 초기화
    }

    public static LottoNumber[] values() { // private 불변 배열을 clone해 제공
        return LOTTO_NUMBERS.clone();
    }

    @Getter
    private static class LottoNumber {
        // private 내부 class -> 외부 Class에서만 LottoNumber class 생성 가능
        // -> 외부 Class에서 내부 Class 생성 시, 멤버 필드에 자유롭게 접근 가능
        final int number; // 접근 제한자 명시x -> default
        LottoNumber(int number) { // 1~45 숫자 받아 객체 생성할 것임
            if (number < ONE || number > LOTTO_RANGE) {
                throw new IllegalArgumentException();
            }
            this.number = number;
        }
    }
}
