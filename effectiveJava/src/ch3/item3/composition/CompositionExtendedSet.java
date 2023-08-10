package ch3.item3.composition;

import java.util.Collection;
import java.util.Set;

public class CompositionExtendedSet<E> extends ForwardingSet<E> {
    // ForwardingSet: 포함하고 있는 객체의 메소드를 호출&전달하는 위임 ClASS
    // CompositionExtendedSet: 위임Class를 확장 -> 원하는 공통 기능 재사용 + 수정/추가 가능
    // Delegation Pattern
    private int addCount = 0;
    public CompositionExtendedSet(Set<E> s) {
        super(s); // ForwardingSet 객체 생성= s 전달 받아 Set을 멤버로 가짐
    }

    @Override // 기능 추가를 위한 override
    public boolean add(E e) {
        // ForwardingSet이라는 위임CLass의 공통 메소드 활용 + 추가 기능(addCount 세기)
        addCount++; // 추가 기능
        return super.add(e); // 위임 class의 공통 메소드 호출
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addCount += collection.size();
        return super.addAll(collection);
    }

    public int getAddCount() {
        return addCount;
    }
}
