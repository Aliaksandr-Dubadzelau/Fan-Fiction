package servlet;

import entity.ConstantsDB;
import entity.ProjectURL;
import entity.RequestSQL;
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
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminPanel")
public class AdminPanel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int delete = Integer.parseInt(request.getParameter("delete"));

        DBService dbService = new DBService();

        String url = ConstantsDB.DATABASE_URL.getData();
        String login = ConstantsDB.LOGIN.getData();
        String password = ConstantsDB.PASSWORD.getData();
        String dbUsers = ConstantsDB.USERS_TABLE.getData();

        String select = RequestSQL.SELECT.getRequest();
        String selectRequestSQL = select + dbUsers;

        List<User> users = dbService.getUsers(url, login, password, selectRequestSQL);

        for (int i = 0; i < users.size(); i++) {
            if (delete == i) {

                User deletedUser = users.get(i);


                String deleteSQL = RequestSQL.DELETE.getRequest();
                String whereSQL = RequestSQL.WHERE.getRequest();
                String usersLoginSQL = RequestSQL.USERS_LOGIN.getRequest();
                String requestSQL = deleteSQL + dbUsers + whereSQL + usersLoginSQL + " = '" + deletedUser.getLogin() + "'";



                dbService.editTable(url, login, password, requestSQL);
                break;
            }
        }

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ProjectURL.SUCCESSFUL_DELETION.getURL());
        requestDispatcher.forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBService dbService = new DBService();

        String url = ConstantsDB.DATABASE_URL.getData();
        String login = ConstantsDB.LOGIN.getData();
        String password = ConstantsDB.PASSWORD.getData();
        String dbUsers = ConstantsDB.USERS_TABLE.getData();

        String selectSQL = RequestSQL.SELECT.getRequest();

        List<User> users = dbService.getUsers(url, login, password, selectSQL + dbUsers);

        request.setAttribute("users", users);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ProjectURL.ADMIN_PANEL_JSP.getURL());
        requestDispatcher.forward(request, response);

    }
}
