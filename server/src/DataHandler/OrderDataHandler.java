package DataHandler;

import sample.Classes.*;
import Database.*;
import Interfaces.*;
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class OrderDataHandler implements IObjectService {
    private int idClient;
    private Socket socket;
    private ObjectInputStream messageFromClient;
    private ObjectOutputStream writeMessage;


    private Database database;

    public OrderDataHandler(int countUser, Socket socket, Database database, ObjectInputStream messageFromClient, ObjectOutputStream writeMessage) {
        this.idClient = countUser;
        this.socket = socket;
        this.database = database;
        this.messageFromClient = messageFromClient;
        // this.writeMessage = writeMessage;
    }


    @Override
    public LinkedList<OrderView> showAll()
    {
        return database.SelectAllOrders();
    }

    @Override
    public void addInDatabase() {
        try
        {
            Order order;
            order = ((Order) messageFromClient.readObject());

            database.WriteOrder(order);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void changeInDatabase() {
    }


    @Override
    public void delete()
    {
        try
        {
            OrderView order;
            order = ((OrderView) messageFromClient.readObject());

            database.DeleteOrder(order);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<OrderView> showAllById()
    {
        String id;
        try {
            id = ((String) messageFromClient.readObject());
            return database.SelectAllOrdersById(id);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCount()
    {
        try {
        String dateAndid = ((String) messageFromClient.readObject());

        return database.getCountOrder(dateAndid);

    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
        return 0;
    }
}
