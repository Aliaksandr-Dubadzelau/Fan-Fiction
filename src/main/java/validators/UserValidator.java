package validators;

import entity.User;
import services.DBService;

public class UserValidator {

    public boolean check(User user){

        DBService serviceDB = new DBService();

        return serviceDB.isLoginDB("jdbc:postgresql://localhost:5432/UsersDB", "Aliaksandr Dubadzelau", "551408", "usersdb", user);
    }

}
