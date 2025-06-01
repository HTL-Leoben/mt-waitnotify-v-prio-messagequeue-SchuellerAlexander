package at.htlle.pos4.prio_messagequeue;

public class Message implements Comparable<Message> {
    private final String content;
    private final int priority;

    public Message(String content, int priority) {
        this.content = content;
        this.priority = priority;
    }

    public int getPriority() { return priority; }
    public String getContent() { return content; }

    @Override
    public int compareTo(Message o) {
        return Integer.compare(o.priority, this.priority); // absteigend!
    }
}

