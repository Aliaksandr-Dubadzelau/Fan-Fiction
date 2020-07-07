package entity;

public enum ProjectURL {
    SIGN_IN("/SignIn"),
    SIGN_UP("/SignUp"),
    MESSENGER_MAIN_WINDOW("/MessengerMainWindow"),
    NOT_FOUND("/pages/errors/404.html"),
    EMPTY_FIELD("/pages/errors/emptyField.jsp"),
    MISMATCHED_PASSWORD("/pages/errors/mismatchedPasswords.jsp"),
    NO_SUCH_USER("/pages/errors/noSuchUser.jsp"),
    SUCH_USER_EXISTED("/pages/errors/suchUserExisted.jsp"),
    SIGN_IN_JSP("/pages/signIn/signIn.jsp"),
    SIGN_UP_JSP("/pages/signUp/signUp.jsp"),
    MESSENGER_MAIN_WINDOW_JSP("/pages/mainMessengerWindow/messengerMainWindow.jsp"),
    ADMIN_PANEL_JSP("/pages/adminPanel/adminPanel.jsp");

    private String URL;

    private ProjectURL(String URL) {
        this.URL = URL;
    }

    public String  getURL() {
        return URL;
    }
}
