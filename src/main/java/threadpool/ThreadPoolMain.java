package threadpool;

public class ThreadPoolMain {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2);
        for (int i = 0; i < 5; i++) {
            int taskID = i;
            threadPool.execute(() -> {
                String message = Thread.currentThread().getName() + ": Task " + taskID;
                System.out.println(message);
            });
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
