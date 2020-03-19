package printinorder.multithreading.hard;

class FooSingleton {

    private static FooSingleton instance = null;

    private FooSingleton() {
    }

    static FooSingleton getInstance() {
        if (instance == null) {
            synchronized (FooSingleton.class) {
                if (instance == null) {
                    instance = new FooSingleton();
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