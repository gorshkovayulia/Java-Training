package threadpool;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {
    private final BlockingQueue<Runnable> taskQueue;
    private volatile boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue<Runnable> queue) {
        this.taskQueue = queue;
    }

    @Override
    public void run() {
        while (!isStopped()) {
            try {
                Runnable runnable = taskQueue.take();
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void doStop() {
        isStopped = true;
    }

    public boolean isStopped() {
        return isStopped;
    }
}
