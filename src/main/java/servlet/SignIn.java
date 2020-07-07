package servlet;

import entity.ProjectURL;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
            response.sendRedirect(ProjectURL.EMPTY_FIELD.getURL());
        }
        else if (isUserExisted) {


            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect(ProjectURL.MESSENGER_MAIN_WINDOW.getURL());
        }
        else {
            response.sendRedirect(ProjectURL.NO_SUCH_USER.getURL());
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ProjectURL.SIGN_IN_JSP.getURL());
        requestDispatcher.forward(request, response);

    }
}
