package ch4.item2.functional;

@FunctionalInterface
public interface ApplyFunction<T> {
    T apply(T arg);
}
