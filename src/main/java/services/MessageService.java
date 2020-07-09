package services;

import entity.Message;
import entity.User;

public class MessageService {

    public Message getMessage(User user, String message)
    {

        String currentMessage = user.getLogin() + ": " + message;

        return new Message(currentMessage);
    }

    public Message getMessage(String message)
    {
        return new Message(message);
    }

}
