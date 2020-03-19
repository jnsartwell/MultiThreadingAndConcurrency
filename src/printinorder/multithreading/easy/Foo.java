package printinorder.multithreading.easy;

class Foo {

    public  Foo() {
    }

    void first(Runnable printFirst) {
        printFirst.run();
    }

    void second(Runnable printSecond) {
        printSecond.run();
    }

    void third(Runnable printThird) {
        printThird.run();
    }

}