package at.htlle.pos4.prio_messagequeue;

public class Message {
    private Boolean isPrio;
    private String content;

    public Message(Boolean isPrio, String content) {
        this.isPrio = isPrio;
        this.content = content;
    }

    public Boolean isPriority() {
        return isPrio;
    }

    public void setPrio(Boolean prio) {
        isPrio = prio;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "isPrio=" + isPrio +
                ", content='" + content + '\'' +
                '}';
    }
}
