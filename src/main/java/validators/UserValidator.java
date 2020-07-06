package validators;

import entity.User;
import services.DBService;

public class UserValidator {

    public boolean check(User user){

        DBService service = new DBService();

        return service.isLoginDB("jdbc:postgresql://localhost:5432/UsersDB", "Aliaksandr Dubadzelau", "551408", "usersdb", user);
    }

}
