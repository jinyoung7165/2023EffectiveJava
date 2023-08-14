package ch4.item1;

import java.util.Collection;
public interface Stack<E> {
    void push(E e);
    E pop();
    boolean isEmpty();

    void pushAll(Iterable<? extends E> integers);

    void popAll(Collection<? super E> objects);
}
