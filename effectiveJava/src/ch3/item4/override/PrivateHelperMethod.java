package ch3.item4.override;

// SubClass에서 doSomething 재정의해도, 다른 method 동작에 영향x
// doSomethingInternal 호출 -> 클래스의 동작 유지
public class PrivateHelperMethod {
    public void doSomething() { // 재정의 가능 메소드
        doSomethingInternal();
    }

    public void doSomethingElse() {  // 재정의 가능 메소드
        doSomethigElseInternal();
    }

    private void doSomethingInternal() {

    }

    private void doSomethigElseInternal() {

    }
}
