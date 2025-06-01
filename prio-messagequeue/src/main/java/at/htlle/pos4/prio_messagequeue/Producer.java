package at.htlle.pos4.prio_messagequeue;

import java.util.Random;

public class Producer extends Thread {
    private final PriorityMessageQueue queue;
    private final String name;

    public Producer(String name, PriorityMessageQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            int priority = (int) (Math.random() * 10); // zufällige Priorität
            Message msg = new Message(name + " msg " + i, priority);
            queue.put(msg); // Nachricht wird in Queue gelegt
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        }
    }
}
