package entity;

public enum RequestSQL {

    SELECT("SELECT * FROM "),
    DELETE("DELETE FROM "),
    INSERT("INSERT INTO "),
    WHERE(" WHERE "),
    VALUES(" VALUES "),
    USERS_LOGIN(" login "),
    USERS_PASSWORD(" password "),
    MESSAGE(" message ");

    private String request;

    RequestSQL(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }
}
