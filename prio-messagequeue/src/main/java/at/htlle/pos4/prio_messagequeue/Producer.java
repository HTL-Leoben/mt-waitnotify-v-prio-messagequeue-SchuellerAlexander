package at.htlle.pos4.prio_messagequeue;

import java.util.Random;

public class Producer extends Thread {
    private final PriorityMessageQueue queue;
    private final String name;
    private final Random random = new Random();

    public Producer(String name, PriorityMessageQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000)); // zufällige Pause
                boolean priority = random.nextBoolean();
                String content = name + ": Message " + System.currentTimeMillis();
                Message msg = new Message(priority, content);
                queue.sendMessage(msg);
                System.out.println(name + " sent: " + msg);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
