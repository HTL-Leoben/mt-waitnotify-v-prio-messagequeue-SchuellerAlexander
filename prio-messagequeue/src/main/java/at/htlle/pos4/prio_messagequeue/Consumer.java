package at.htlle.pos4.prio_messagequeue;

import java.util.Random;

public class Consumer extends Thread {
    private final PriorityMessageQueue queue;
    private final String name;

    public Consumer(String name, PriorityMessageQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message msg = queue.take(); // blockiert, falls leer
                System.out.println(name + " received: " + msg.getContent() + " (prio " + msg.getPriority() + ")");
                Thread.sleep(200); // verarbeitet Nachricht
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
