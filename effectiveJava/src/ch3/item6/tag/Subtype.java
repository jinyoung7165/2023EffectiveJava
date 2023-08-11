package ch3.item6.tag;

// Tag를 class내부에 저장해 SRP 해치는 문제 해결
// subtyping: tag별 달라지는 동작 -> 추상 메소드
// 그외 공통 일관된 메소드 -> default
public abstract class Subtype {
    abstract double area();
}
