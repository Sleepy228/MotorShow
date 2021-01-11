package DataHandler;

import sample.Classes.*;
import Database.*;
import Interfaces.*;
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class UserDataHandler implements IObjectService {
    private int idClient;
    private Socket socket;
    private ObjectInputStream messageFromClient;
    private ObjectOutputStream writeMessage;


    private Database database;

    public UserDataHandler(int countUser, Socket socket, Database database, ObjectInputStream messageFromClient, ObjectOutputStream writeMessage) {
        this.idClient = countUser;
        this.socket = socket;
        this.database = database;
        this.messageFromClient = messageFromClient;
       // this.writeMessage = writeMessage;
    }


    @Override
    public LinkedList<User> showAll()
    {
        return null;
    }



    @Override
    public void addInDatabase() {
        try
        {
            User user;
            user = ((User) messageFromClient.readObject());
            database.WriteUser(user);
         } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String сheckInDatabase()
    {
        try
        {
            User user;
            user = ((User) messageFromClient.readObject());
            String flag = database.CheckUserInDatabase(user);
            return  flag;
        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeInDatabase() {
    }


    @Override
    public void delete() {
    }

    public int findUser(String login)
    {
        return database.findUserId(login);
    }
}
