package printinorder.multithreading.easy;

class Foo {

    private boolean firstLocked;
    private boolean secondLocked;
    private boolean thirdLocked;

    Foo() {
        firstLocked = false;
        secondLocked = true;
        thirdLocked = true;
    }

    void first(Runnable printFirst) {
        while (firstLocked) {
        }
        printFirst.run();
        firstLocked = true;
        secondLocked = false;
    }

    void second(Runnable printSecond) {
        while (secondLocked) {
        }
        printSecond.run();
        secondLocked = true;
        thirdLocked = false;
    }

    void third(Runnable printThird) {
        while (thirdLocked) {
        }
        printThird.run();
    }

}