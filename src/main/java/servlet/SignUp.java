package servlet;

import entity.ConstantsDB;
import entity.ProjectURL;
import entity.RequestSQL;
import entity.User;
import services.DBService;
import services.UserService;
import validators.EmptyFieldValidator;
import validators.MismatchedPasswordValidator;
import validators.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBService dbService = new DBService();
        UserService userService = new UserService();

        MismatchedPasswordValidator passwordValidator = new MismatchedPasswordValidator();
        UserValidator userValidator = new UserValidator();
        EmptyFieldValidator emptyFieldValidator = new EmptyFieldValidator();

        String userLogin = request.getParameter("login");
        String userPassword = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");

        boolean isEmptyLogin = emptyFieldValidator.check(userLogin);
        boolean isEmptyPassword = emptyFieldValidator.check(userPassword);
        boolean isEmptyRepeatPassword = emptyFieldValidator.check(repeatPassword);

        String url = ConstantsDB.DATABASE_URL.getData();
        String login = ConstantsDB.LOGIN.getData();
        String password = ConstantsDB.PASSWORD.getData();
        String dbUsers = ConstantsDB.USERS_TABLE.getData();

        if (isEmptyLogin || isEmptyPassword || isEmptyRepeatPassword) {
            response.sendRedirect(ProjectURL.EMPTY_FIELD.getURL());
        }
        else {
            if (passwordValidator.comparePassword(userPassword, repeatPassword)) {
                response.sendRedirect(ProjectURL.MISMATCHED_PASSWORD.getURL());
            } else {

                User user = userService.getUser(userLogin, userPassword);
                boolean isUserExist = userValidator.checkLogin(user);

                if (isUserExist) {
                    response.sendRedirect(ProjectURL.SUCH_USER_EXISTED.getURL());
                } else {

                    String insertSQL = RequestSQL.INSERT.getRequest();
                    String valuesSQL = RequestSQL.VALUES.getRequest();
                    String loginSQL = RequestSQL.USERS_LOGIN.getRequest();
                    String passwordSQL = RequestSQL.USERS_PASSWORD.getRequest();
                    String requestSQL = insertSQL + dbUsers + " (" + loginSQL + " , " + passwordSQL + ")" + valuesSQL + "('" + user.getLogin() + "','" + user.getPassword() + "')";

                    dbService.editTable(url, login, password, requestSQL);
                    response.sendRedirect(ProjectURL.SIGN_IN.getURL());
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ProjectURL.SIGN_UP_JSP.getURL());
        requestDispatcher.forward(request, response);

    }
}
