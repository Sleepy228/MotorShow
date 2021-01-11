package DataHandler;

import sample.Classes.*;
import Database.*;
import Interfaces.*;
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class CarBrandDataHandler implements IObjectService {
    private int idClient;
    private Socket socket;
    private ObjectInputStream messageFromClient;
    private ObjectOutputStream writeMessage;


    private Database database;

    public CarBrandDataHandler(int countUser, Socket socket, Database database, ObjectInputStream messageFromClient, ObjectOutputStream writeMessage) {
        this.idClient = countUser;
        this.socket = socket;
        this.database = database;
        this.messageFromClient = messageFromClient;
        // this.writeMessage = writeMessage;
    }


    @Override
    public LinkedList<CarBrand> showAll()
    {
        return database.SelectAllCarBrand();
    }

    @Override
    public void addInDatabase() {
        try
        {
            Employee employee;
            User user;

            employee = ((Employee) messageFromClient.readObject());
            user = ((User) messageFromClient.readObject());

            employee.setIdUser(database.findUserId(user.getLogin()));
            database.WriteEmployee(employee);

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
