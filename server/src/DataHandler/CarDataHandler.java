package DataHandler;

import sample.Classes.*;
import Database.*;
import Interfaces.*;
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class CarDataHandler implements IObjectService {
    private int idClient;
    private Socket socket;
    private ObjectInputStream messageFromClient;
    private ObjectOutputStream writeMessage;


    private Database database;

    public CarDataHandler(int countUser, Socket socket, Database database, ObjectInputStream messageFromClient, ObjectOutputStream writeMessage) {
        this.idClient = countUser;
        this.socket = socket;
        this.database = database;
        this.messageFromClient = messageFromClient;
        // this.writeMessage = writeMessage;
    }


    public LinkedList<CarView> showAllbyFilter()
    {
        try {
            String filterString = (String) messageFromClient.readObject();
            return database.SelectAllCarByFilter(filterString);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
       return null;
    }

    public LinkedList<CarView> showAllbyFilterAvail()
    {
        try {
            String filterString = (String) messageFromClient.readObject();
            return database.SelectAllCarByFilterAvail(filterString);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LinkedList<CarView> showAll()
    {
        return database.SelectAllCar();
    }

    public LinkedList<CarView> showAllAvail()
    {
        return database.SelectAllCarAvail();
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
