package servlet;

import entity.User;
import services.DBService;
import services.UserService;
import validators.EmptyFieldValidator;
import validators.MismatchedPasswordValidator;
import validators.UserValidator;

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

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");

        boolean isEmptyLogin = emptyFieldValidator.check(login);
        boolean isEmptyPassword = emptyFieldValidator.check(password);
        boolean isEmptyRepeatPassword = emptyFieldValidator.check(repeatPassword);

        if (isEmptyLogin || isEmptyPassword || isEmptyRepeatPassword) {
            response.sendRedirect("/errors/emptyField.jsp");
        }
        else {
            if (passwordValidator.comparePassword(password, repeatPassword)) {
                response.sendRedirect("/errors/mismatchedPasswords.jsp");
            } else {

                User user = userService.getUser(login, password);
                boolean isUserExist = userValidator.check(user);

                if (isUserExist) {
                    response.sendRedirect("/errors/suchUserExisted.jsp");
                } else {

                    dbService.addEntity("jdbc:postgresql://localhost:5432/UsersDB", "Aliaksandr Dubadzelau", "551408", "usersdb", user);
                    response.sendRedirect("/signIn/signIn.html");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
