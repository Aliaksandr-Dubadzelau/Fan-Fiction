package servlet;

import entity.Message;
import entity.ProjectURL;
import entity.User;
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

        User user = (User) request.getSession().getAttribute("user");
        String messageArea = request.getParameter("message");

        Message message = messageService.getMessage(user, messageArea);

        dbService.addMessage("jdbc:postgresql://localhost:5432/UsersDB", "Aliaksandr Dubadzelau", "551408", "messagesdb", message);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ProjectURL.SUCCESSFUL_ADDED.getURL());
        requestDispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBService dbService = new DBService();

        List<Message> messages = dbService.getMessages("jdbc:postgresql://localhost:5432/UsersDB", "Aliaksandr Dubadzelau", "551408", "messagesdb");

        request.setAttribute("messages", messages);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ProjectURL.MESSENGER_MAIN_WINDOW_JSP.getURL());
        requestDispatcher.forward(request, response);

    }


}
