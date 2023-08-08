package ch1.item3.genericfactory;

import ch1.item3.genericfactory.functional.ApplyFunction;
import lombok.Data;

@Data
public class GenericFactory implements SingletonBase {
    private static ApplyFunction<Object> IDENTITY_FUNCTION = arg -> {
        System.out.println("arg = " + arg);
        return arg;
    }; // 매개변수 출력만 해주는 함수형 인터페이스

    // static lambda function의 Generic Type 지정
    @SuppressWarnings("unchecked")
    public static <T> ApplyFunction<T> identityFunction() {
        return (ApplyFunction<T>) IDENTITY_FUNCTION;
    }

    @Override
    public void print() {
        System.out.println("Generic Singleton Factory");
    }
}
