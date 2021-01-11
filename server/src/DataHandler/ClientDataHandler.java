package DataHandler;

import Constants.Constants;
import sample.Classes.*;
import Database.*;
import Interfaces.*;
import java.io.*;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ClientDataHandler implements IObjectService {
    private int idClient;
    private Socket socket;
    private ObjectInputStream messageFromClient;
    private ObjectOutputStream writeMessage;


    private Database database;

    public ClientDataHandler(int countUser, Socket socket, Database database, ObjectInputStream messageFromClient, ObjectOutputStream writeMessage) {
        this.idClient = countUser;
        this.socket = socket;
        this.database = database;
        this.messageFromClient = messageFromClient;
        // this.writeMessage = writeMessage;
    }


    @Override
    public LinkedList<ClientView> showAll()
    {
        return database.SelectAllClients();
    }

    public LinkedList<ClientView> showAllbyFilter()
    {
        try {
            String filterString = (String) messageFromClient.readObject();
            return database.SelectAllClientsByFilter(filterString);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addInDatabase() {
        try
        {
            Client client;

            client = ((Client) messageFromClient.readObject());

            database.WriteClient(client);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void changeInDatabase()
    {
        ClientView client;

        try {
            client = ((ClientView) messageFromClient.readObject());

            database.ChangeClient(client);

            Integer passportNumber = database.getPaasportNumberInClient(client);
            database.ChangePassportClient(passportNumber, client);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void delete() {
        try
        {
            ClientView clientView;
            clientView = ((ClientView) messageFromClient.readObject());

            database.DeleteOrderByClient(clientView);
            int passportNumbar = database.getPaasportNumberInClient(clientView);
            database.DeleteClient(clientView);
            database.DeletePassportByClient(passportNumbar);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
