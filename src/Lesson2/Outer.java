package Lesson2;

public class Outer {

    public Outer(int outerVar) {
        this.outerVar = outerVar;
    }

    private int outerVar;

    class Inner {
        private int innerVar;

        public Inner(int innerVar) {
            this.innerVar = innerVar;
        }

        void innerTest() {
            System.out.println(innerVar);
            System.out.println(outerVar);
        }
    }

    void outerTest() {
       // System.out.println(innerVar);
        System.out.println(outerVar);
    }
}

class MainOuterAndInner {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer(10).new Inner(50);
    }
}
