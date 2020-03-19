package printinorder.multithreading.hard;

class FooSingleton {

    private static FooSingleton instance = null;
    private boolean firstGateOpen, secondGateOpen, thirdGateOpen;

    private FooSingleton() {
        firstGateOpen = true;
        secondGateOpen = false;
        thirdGateOpen = false;
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

    synchronized void first(Runnable printFirst) {
        while (!firstGateOpen) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printFirst.run();
        openGates(false, true, false);
        notifyAll();
    }

    synchronized void second(Runnable printSecond) {
        while (!secondGateOpen) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printSecond.run();
        openGates(false, false, true);
        notifyAll();
    }

    synchronized void third(Runnable printThird) {
        while (!thirdGateOpen) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printThird.run();
        openGates(true, false, false);
        notifyAll();
    }

    private void openGates(boolean openFirstGate, boolean openSecondGate, boolean openThirdGate) {
        this.firstGateOpen = openFirstGate;
        this.secondGateOpen = openSecondGate;
        this.thirdGateOpen = openThirdGate;
    }

}