package DataHandler;

import sample.Classes.*;
import Database.*;
import Interfaces.*;
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class PassportDataHandler implements IObjectService {
    private int idClient;
    private Socket socket;
    private ObjectInputStream messageFromClient;
    private ObjectOutputStream writeMessage;


    private Database database;

    public PassportDataHandler(int countUser, Socket socket, Database database, ObjectInputStream messageFromClient, ObjectOutputStream writeMessage) {
        this.idClient = countUser;
        this.socket = socket;
        this.database = database;
        this.messageFromClient = messageFromClient;
        // this.writeMessage = writeMessage;
    }


    @Override
    public LinkedList<Passport> showAll()
    {
        return null;
    }

    @Override
    public void addInDatabase() {
        try
        {
            Passport passport;
            passport = ((Passport) messageFromClient.readObject());
            database.WritePassport(passport);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void changeInDatabase() {
    }


    @Override
    public void delete() {
    }
}
