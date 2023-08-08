package ch1.item3.genericfactory;

import ch1.item3.genericfactory.functional.ApplyFunction;

public abstract class GenericFactoryTest {
    private GenericFactoryTest() {}
    public static void main(String[] args) {
        // 함수형 interface type 지정: Integer
        ApplyFunction<Integer> applyFunction = GenericFactory.identityFunction();

        // arg 출력만 하는 함수
        // Integer type 반환할 것
        Object apply = applyFunction.apply(123);
        System.out.println("apply = " + apply.getClass());
    }
}
