package servlet;

import com.sun.org.apache.xerces.internal.impl.dv.DVFactoryException;
import entity.User;
import services.DBService;
import services.UserService;
import validators.EmptyFieldValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBService dbService = new DBService();
        UserService userService = new UserService();

        EmptyFieldValidator emptyFieldValidator = new EmptyFieldValidator();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.getUser(login, password);

        boolean isUserExisted = dbService.isEntityDB("jdbc:postgresql://localhost:5432/UsersDB", "Aliaksandr Dubadzelau", "551408", "usersdb", user);
        boolean isEmptyLogin = emptyFieldValidator.check(login);
        boolean isEmptyPassword = emptyFieldValidator.check(password);

        if(isEmptyLogin || isEmptyPassword){
            response.sendRedirect("/errors/emptyField.jsp");
        }
        else if (isUserExisted) {
            response.sendRedirect("/mainMessengerWindow/messengerMainWindow.html");
        }
        else {
            response.sendRedirect("/errors/noSuchUser.jsp");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
