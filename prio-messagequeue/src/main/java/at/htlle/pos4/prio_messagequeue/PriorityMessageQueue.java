package at.htlle.pos4.prio_messagequeue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class PriorityMessageQueue {
    private final List<Message> queue = new LinkedList<>();

    public synchronized void put(Message msg) {
        queue.add(msg);
        queue.sort(null); // sortiert mit compareTo
        notifyAll(); // weckt wartende Threads
    }

    public synchronized Message take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wartet auf neue Nachricht
        }
        return queue.remove(0); // höchste Priorität
    }
}
