package multithreading;

class Foo {

    private static Foo instance = null;

    private Foo() {
    }

    static Foo getInstance() {
        if (instance == null) {
            synchronized (Foo.class) {
                if (instance == null) {
                    instance = new Foo();
                }
            }
        }
        return instance;
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