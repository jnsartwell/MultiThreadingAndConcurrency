package multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ConcurrencyThreading {

    private ISystemWrapper systemWrapper;

    ConcurrencyThreading(ISystemWrapper systemWrapper) {
        this.systemWrapper = systemWrapper;
    }

    void execute(int[] threadOrder) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadOrder.length);
        startThreads(executorService, threadOrder);
        awaitTerminationAfterShutdown(executorService);
    }

    private void startThreads(ExecutorService executorService, int[] threadOrder) {
        Foo foo = new Foo();
        for (int i : threadOrder) {
            if (i == 1)
                executorService.execute(() -> {
                    try {
                        foo.first(() -> this.systemWrapper.print("first"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            if (i == 2)
                executorService.execute(() -> {
                    try {
                        foo.second(() -> this.systemWrapper.print("second"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            if (i == 3)
                executorService.execute(() -> {
                    try {
                        foo.third(() -> this.systemWrapper.print("third"));
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
