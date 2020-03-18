package multithreading;

class Foo {

    private static Foo instance = null;

    private Foo() {
    }

    public static Foo getInstance() {
        if (instance == null) {
            synchronized (Foo.class) {
                if (instance == null) {
                    instance = new Foo();
                }
            }
        }
        return instance;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        printThird.run();
    }

}