package ch4.item1;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class GenericStack<E> implements Stack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public GenericStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    @Override
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    @Override
    public E pop() {
        if (size == 0) throw new EmptyStackException();
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null; // mem 참조 해제
        return result;
    }

    @Override
    public void pushAll(Iterable<? extends E> src) { // E의 하위 Class 객체로 이뤄진 Iterable도 push 가능
        for (E e : src) push(e); // src는 새 원소를 넣기 위해 생산할 것 -> extends
    }
    @Override
    public void popAll(Collection<? super E> dst) { // E의 상위 class인 object에 담기 가능
        while (!isEmpty()) dst.add(pop()); // dst는 존재하는 원소를 자기쪽으로 넣기 위해 소비할 것 -> super
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, size*2+1);
        }
    }
}
