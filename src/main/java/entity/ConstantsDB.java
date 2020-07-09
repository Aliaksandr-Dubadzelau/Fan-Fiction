package entity;

public enum ConstantsDB {

    DATABASE_URL("jdbc:postgresql://localhost:5432/FanFictionDB"),
    MESSAGES_TABLE("messagesdb"),
    USERS_TABLE("usersdb"),
    LOGIN("Aliaksandr Dubadzelau"),
    PASSWORD("551408");

    private String data;

    ConstantsDB(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
