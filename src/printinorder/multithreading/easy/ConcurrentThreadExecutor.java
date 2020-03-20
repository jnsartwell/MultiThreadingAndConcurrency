package printinorder.multithreading.easy;

import printinorder.multithreading.system.ISystemWrapper;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ConcurrentThreadExecutor {

    private ISystemWrapper systemWrapper;

    ConcurrentThreadExecutor(ISystemWrapper systemWrapper) {
        this.systemWrapper = systemWrapper;
    }

    void execute(int[] threadOrder) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadOrder.length);
        startThreads(executorService, threadOrder);
        awaitTerminationAfterShutdown(executorService);
    }

    private void startThreads(ExecutorService executorService, int[] threadOrder) {
        Foo foo = new Foo();
        ThreadCoordinator coordinator = new ThreadCoordinator();

        Arrays.sort(threadOrder);

        for (int i : threadOrder) {
            if (i == 1)
                executorService.execute(() -> foo.first(() -> {
                    systemWrapper.print("first");
                    coordinator.set_FirstFinished(true);
                }));
            if (i == 2)
                executorService.execute(() -> {
                    while (!coordinator.firstFinished()) {
                    }
                    foo.second(() -> {
                        systemWrapper.print("second");
                        coordinator.set_SecondFinished(true);
                    });
                });
            if (i == 3)
                executorService.execute(() -> {
                    while (!coordinator.secondFinished()) {
                    }
                    foo.third(() -> systemWrapper.print("third"));
                });
        }
    }

    private void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
