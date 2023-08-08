package ch1.item3.genericfactory.functional;

@FunctionalInterface
public interface ApplyFunction<T> {
    T apply(T arg);
}
