package entity;

public enum ProjectURL {
    SIGN_IN("/SignIn"),
    SIGN_UP("/SignUp"),
    ADMIN_PANEL("/AdminPanel"),
    MESSENGER_MAIN_WINDOW("/FanFictionMainWindow"),
    NOT_FOUND("/pages/errors/404.html"),
    EMPTY_FIELD("/pages/errors/emptyField.jsp"),
    MISMATCHED_PASSWORD("/pages/errors/mismatchedPasswords.jsp"),
    NO_SUCH_USER("/pages/errors/noSuchUser.jsp"),
    SUCH_USER_EXISTED("/pages/errors/suchUserExisted.jsp"),
    SIGN_IN_JSP("/pages/signIn/signIn.jsp"),
    SIGN_UP_JSP("/pages/signUp/signUp.jsp"),
    MESSENGER_MAIN_WINDOW_JSP("/pages/fanFictionMainWindow/fanFictionMainWindow.jsp"),
    ADMIN_PANEL_JSP("/pages/adminPanel/adminPanel.jsp"),
    SUCCESSFUL_DELETION("/pages/adminPanel/successfulDeletion.jsp"),
    SUCCESSFUL_ADDED("/pages/fanFictionMainWindow/successfullyAdded.jsp");

    private String URL;

    private ProjectURL(String URL) {
        this.URL = URL;
    }

    public String  getURL() {
        return URL;
    }
}
