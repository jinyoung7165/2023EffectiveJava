package ch3.item3.composition;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// 모든 메소드 호출을 포함 중인 멤버 객체에 전달하는 Class : 위임 Class
// Delegation Pattern
// -> ForwardingSet의 자식 Class는 기능을 변경 + 공통 동작 재사용 가능
public class ForwardingSet<E> implements Set<E> {
    // 자식class를 위한 공통 기능 모아둘 것
    // 메소드 호출 시, 실제로는 멤버 객체의 메소드에 호출을 전달하는 용도의 class
    // Set의 모든 메소드 호출 전달을 위해 Set impl
    // 내부 메소드 구현을 멤버 객체인 Set에게 미룸 -> 사용자는 이의 public method 호출 방법만 알면 됨
    private final Set<E> s; // 생성자 매개변수로 Set 받아 멤버로 가질 것-> 메소드 호출 전달

    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    @Override
    public int size() {
        return s.size();
    }

    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return s.iterator();
    }

    @Override
    public Object[] toArray() {
        return s.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return s.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return s.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    @Override
    public void clear() {
        s.clear();
    }
}
