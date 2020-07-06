package services;

import entity.User;

public class UserService {

    public User getUser(String login, String password){
        return new User(login, password);
    }

}
