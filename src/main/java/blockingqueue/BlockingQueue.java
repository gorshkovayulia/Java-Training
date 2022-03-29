package blockingqueue;

import java.util.LinkedList;

public class BlockingQueue {
    private final LinkedList<Object> queue = new LinkedList<>();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void put(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            System.out.println("[BlockingQueue] queue is full, waiting until space is free");
            wait();
        }
        if (this.queue.size() == 0) {
            System.out.println("[BlockingQueue] queue is empty, notify");
            notifyAll();
        }
        this.queue.add(item);
        System.out.println("[BlockingQueue] put ok: " + item);
    }

    public synchronized Object take() throws InterruptedException {
        while (this.queue.size() == 0) {
            System.out.println("[BlockingQueue] queue is empty, waiting until smth is put");
            wait();
        }
        if (this.queue.size() == this.limit) {
            System.out.println("[BlockingQueue] queue is full, notify");
            notifyAll();
        }
        Object item = this.queue.remove(0);
        System.out.println("[BlockingQueue] take ok: " + item);
        return item;
    }
}
