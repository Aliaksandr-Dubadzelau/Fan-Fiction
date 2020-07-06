import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean isExisted = false;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UsersDB", "Aliaksandr Dubadzelau", "551408")) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM usersdb");

            while (resultSet.next()) {

                String dbLogin = resultSet.getString(2);
                String dbPassword = resultSet.getString(3);

                if (dbLogin.equals(login) && dbPassword.equals(password)) {
                    isExisted = true;
                    break;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isExisted) {
            response.sendRedirect("/mainMessengerWindow/messengerMainWindow.html");
        }
        else {
            response.sendRedirect("/signIn/signIn.html");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
