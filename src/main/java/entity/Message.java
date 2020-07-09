package entity;

public class Message {

    private String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }



    @Override
    public String toString() {
        return text + "\n";
    }
}
