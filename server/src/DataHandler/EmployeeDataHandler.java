package DataHandler;

import sample.Classes.*;
import Database.*;
import Interfaces.*;
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class EmployeeDataHandler implements IObjectService {
    private int idClient;
    private Socket socket;
    private ObjectInputStream messageFromClient;
    private ObjectOutputStream writeMessage;


    private Database database;

    public EmployeeDataHandler(int countUser, Socket socket, Database database, ObjectInputStream messageFromClient, ObjectOutputStream writeMessage) {
        this.idClient = countUser;
        this.socket = socket;
        this.database = database;
        this.messageFromClient = messageFromClient;
        // this.writeMessage = writeMessage;
    }

    public String GetEmployeeID(String flagAndId)
    {
             String [] strings = flagAndId.split(" ");
            return database.GetEmployeeID(strings[1]);
    }

    @Override
    public LinkedList<Employee> showAll()
    {
        return null;
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

   public Employee getEmployeeByid()
   {
       try
       {
       String employeeid = ((String) messageFromClient.readObject());

      return database.getEmployeeById(employeeid);

   } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return  null;
}

    @Override
    public void changeInDatabase() {
    }


    @Override
    public void delete() {
    }
}
