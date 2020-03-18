package multithreading;

import multithreading.system.ISystemWrapper;

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
        for (int i : threadOrder) {
            if (i == 1)
                executorService.execute(() -> {
                    Foo.getInstance().first(() -> systemWrapper.print("first"));
                });
            if (i == 2)
                executorService.execute(() -> {
                    Foo.getInstance().second(() -> systemWrapper.print("second"));
                });
            if (i == 3)
                executorService.execute(() -> {
                    Foo.getInstance().third(() -> systemWrapper.print("third"));
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
