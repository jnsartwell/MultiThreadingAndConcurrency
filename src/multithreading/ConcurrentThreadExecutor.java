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
                    try {
                        Foo.getInstance().first(() -> systemWrapper.print("first"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            if (i == 2)
                executorService.execute(() -> {
                    try {
                        Foo.getInstance().second(() -> systemWrapper.print("second"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            if (i == 3)
                executorService.execute(() -> {
                    try {
                        Foo.getInstance().third(() -> systemWrapper.print("third"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
