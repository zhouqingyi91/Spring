public class Test {
    public static void main(String[] args) {
        A a = new B();
        a.method();
        a.method_B();
    }
}

class A {
    public void method() {
        System.out.println("method in A");
    }

    public void method_B() {
        System.out.println("method_B in A");
    }
}

class B extends A {
    public void method_B() {
        System.out.println("method_B in B");
    }
}
