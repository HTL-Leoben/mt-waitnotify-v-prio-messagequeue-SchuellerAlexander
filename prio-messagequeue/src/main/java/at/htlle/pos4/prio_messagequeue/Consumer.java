package at.htlle.pos4.prio_messagequeue;

import java.util.Random;

public class Consumer extends Thread {
    private final PriorityMessageQueue queue;
    private final String name;
    private final Random random = new Random();

    public Consumer(String name, PriorityMessageQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1500)); // zufällige Pause
                Message msg = queue.receiveMessage();
                System.out.println(name + " received: " + msg);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
