package services;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    public boolean isEntityDB(String url, String name, String password, String db, User user){

        boolean isExisted = false;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statement = connection.createStatement())
        {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + db);

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

    public boolean isLoginDB(String url, String name, String password, String db, User user){

        boolean isExisted = false;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statement = connection.createStatement())
        {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + db);

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

    public void addEntity(String url, String name, String password, String db, User user){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statement = connection.createStatement()
        ){

            statement.executeUpdate("INSERT INTO " + db + " (login, password) VALUES ('" + user.getLogin() + "','" + user.getPassword() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteEntity(String url, String name, String password, String db, User user){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statement = connection.createStatement()
        ){

            statement.executeUpdate("DELETE FROM " + db + " WHERE login = '" + user.getLogin() + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<User> getUsers(String url, String name, String password, String db){

        UserService userService = new UserService();
        List<User> users = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statement = connection.createStatement())
        {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + db);

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
}
