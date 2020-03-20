package printinorder.multithreading.hard;

import printinorder.multithreading.easy.ThreadCoordinator;
import printinorder.multithreading.system.ISystemWrapper;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ConcurrentThreadExecutorWithSingleton {

    private ISystemWrapper systemWrapper;

    ConcurrentThreadExecutorWithSingleton(ISystemWrapper systemWrapper) {
        this.systemWrapper = systemWrapper;
    }

    void execute(int[] threadOrder) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadOrder.length);
        startThreads(executorService, threadOrder);
        awaitTerminationAfterShutdown(executorService);
    }

    private void startThreads(ExecutorService executorService, int[] threadOrder) {
        //Pass threadOrder to the ThreadCoordinator so that threads do not NEED the thread before them to finish
        //  before being able to execute.  Failing test 10 and 11 illustrate the necessity of this change.
        ThreadCoordinator coordinator = new ThreadCoordinator();

        for (int i : threadOrder) {
            if (i == 1)
                executorService.execute(() -> {
                    FooSingleton.getInstance().first(() -> {
                        systemWrapper.print("first");
                        coordinator.set_FirstFinished(true);
                    });
                });
            if (i == 2)
                executorService.execute(() -> {
                    while (!coordinator.firstFinished()) {
                    }
                    FooSingleton.getInstance().second(() -> {
                        systemWrapper.print("second");
                        coordinator.set_SecondFinished(true);
                    });
                });
            if (i == 3)
                executorService.execute(() -> {
                    while (!coordinator.secondFinished()) {
                    }
                    FooSingleton.getInstance().third(() -> systemWrapper.print("third"));
                });
        }
    }

    private void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(5, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
