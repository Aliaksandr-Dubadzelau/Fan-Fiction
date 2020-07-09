package services;

import entity.Message;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    public void editTable(String url, String name, String password, String requestSQL) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(requestSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getResultSet(String url, String name, String password, String requestSQL) throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager.getConnection(url, name, password);
        Statement statement = connection.createStatement();

        return statement.executeQuery(requestSQL);
    }

    public boolean isUserInDB(String url, String name, String password, String requestSQL, User user) {

        boolean isExisted = false;

        try (ResultSet resultSet = getResultSet(url, name, password, requestSQL)) {

            while (resultSet.next()) {

                String dbLogin = resultSet.getString(2);
                String dbPassword = resultSet.getString(3);

                if (dbLogin.equals(user.getLogin()) && dbPassword.equals(user.getPassword())) {
                    isExisted = true;
                    break;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isExisted;

    }

    public boolean isLoginInDB(String url, String name, String password, String requestSQL, User user) {

        boolean isExisted = false;

        try (ResultSet resultSet = getResultSet(url, name, password, requestSQL)) {

            while (resultSet.next()) {

                String dbLogin = resultSet.getString(2);

                if (dbLogin.equals(user.getLogin())) {
                    isExisted = true;
                    break;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isExisted;

    }

    public List<User> getUsers(String url, String name, String password, String requestString) {

        UserService userService = new UserService();
        List<User> users = new ArrayList<>();

        try (ResultSet resultSet = getResultSet(url, name, password, requestString)) {

            while (resultSet.next()) {

                String dbLogin = resultSet.getString(2);
                String dbPassword = resultSet.getString(3);
                User user = userService.getUser(dbLogin, dbPassword);

                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public List<Message> getMessages(String url, String name, String password, String requestSQL) {

        MessageService messageService = new MessageService();
        List<Message> messages = new ArrayList<>();

        try (ResultSet resultSet = getResultSet(url, name, password, requestSQL)) {

            while (resultSet.next()) {

                String dbMessage = resultSet.getString(2);
                Message message = messageService.getMessage(dbMessage);

                messages.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }
}
