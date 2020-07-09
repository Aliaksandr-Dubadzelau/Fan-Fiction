package servlet;

import entity.*;
import services.DBService;
import services.MessageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/FanFictionMainWindow")
public class FanFictionMainWindow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBService dbService = new DBService();
        MessageService messageService = new MessageService();

        String url = ConstantsDB.DATABASE_URL.getData();
        String login = ConstantsDB.LOGIN.getData();
        String password = ConstantsDB.PASSWORD.getData();
        String dbMessages = ConstantsDB.MESSAGES_TABLE.getData();

        User user = (User) request.getSession().getAttribute("user");
        String messageArea = request.getParameter("message");

        Message message = messageService.getMessage(user, messageArea);

        String insertSQL = RequestSQL.INSERT.getRequest();
        String valuesSQL = RequestSQL.VALUES.getRequest();
        String messageSQL = RequestSQL.MESSAGE.getRequest();
        String requestSQL = insertSQL + dbMessages + " (" + messageSQL + ") " + valuesSQL + " ('" + message.toString() + "')";

        dbService.editTable(url, login, password, requestSQL);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ProjectURL.SUCCESSFUL_ADDED.getURL());
        requestDispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBService dbService = new DBService();

        String url = ConstantsDB.DATABASE_URL.getData();
        String login = ConstantsDB.LOGIN.getData();
        String password = ConstantsDB.PASSWORD.getData();
        String dbMessages = ConstantsDB.MESSAGES_TABLE.getData();

        String selectSQL = RequestSQL.SELECT.getRequest();

        String requestSQL = selectSQL + dbMessages;

        List<Message> messages = dbService.getMessages(url, login, password,  requestSQL);
        request.setAttribute("messages", messages);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ProjectURL.MESSENGER_MAIN_WINDOW_JSP.getURL());
        requestDispatcher.forward(request, response);

    }


}
