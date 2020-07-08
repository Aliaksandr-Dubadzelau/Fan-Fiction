package entity;

public class Message {

    private User user;
    private String text;

    public Message() {
    }

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return user.getLogin() + " : " + text + "\n";
    }
}
