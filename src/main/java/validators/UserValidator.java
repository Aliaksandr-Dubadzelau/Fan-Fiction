package validators;

import entity.ConstantsDB;
import entity.RequestSQL;
import entity.User;
import services.DBService;

public class UserValidator{

    public boolean checkLogin(User user){

        DBService serviceDB = new DBService();

        String url = ConstantsDB.DATABASE_URL.getData();
        String login = ConstantsDB.LOGIN.getData();
        String password = ConstantsDB.PASSWORD.getData();
        String dbUsers = ConstantsDB.USERS_TABLE.getData();

        String selectSQL = RequestSQL.SELECT.getRequest();
        String requestSQL = selectSQL + dbUsers;

        return serviceDB.isLoginInDB(url, login, password, requestSQL, user);
    }

    public boolean checkUser(User user){

        DBService serviceDB = new DBService();

        String url = ConstantsDB.DATABASE_URL.getData();
        String login = ConstantsDB.LOGIN.getData();
        String password = ConstantsDB.PASSWORD.getData();
        String dbUsers = ConstantsDB.USERS_TABLE.getData();

        String selectSQL = RequestSQL.SELECT.getRequest();
        String requestSQL = selectSQL + dbUsers;

        return serviceDB.isUserInDB(url, login, password, requestSQL, user);
    }

}
