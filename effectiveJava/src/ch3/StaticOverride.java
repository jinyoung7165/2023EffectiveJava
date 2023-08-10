package ch3;

public class StaticOverride {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        Parent parent2 = new Child();
        Child child = new Child();

        parent1.getTest(); // "parent" 출력
        parent2.getTest(); // 참조 변수 type인 Parent의 static method 호출 "parent" 출력
        child.getTest();   // "child" 출력
    }
}

class Parent {
    public static void getTest() { // static or overloading -> compile Time결정. 동적 dispatch x
        System.out.println("parent");
    }
}

class Child extends Parent {
    public static void getTest() {
        System.out.println("child");
    }
}