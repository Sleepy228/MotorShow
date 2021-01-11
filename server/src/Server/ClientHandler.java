package Server;

import DataHandler.*;
import Database.*;
import sample.Classes.CarModel;
import sample.Classes.Client;
import sample.Classes.User;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class ClientHandler extends Thread
{
    private int idClient;
    private UserDataHandler userHandler;
    private PassportDataHandler passportHandler;
    private EmployeeDataHandler employeeHandler;
    private CarBrandDataHandler carBrandHandler;
    private CarDataHandler carHandler;
    private CarModelDataHandler carModelHandler;
    private ClientDataHandler clientdataHandler;
    private OrderDataHandler orderdataHandler;

    private Socket socket;
    private ObjectInputStream messageFromServer;
    private ObjectOutputStream writeMessage;

    public ClientHandler(Socket socket, Database database, int idClient) {
        this.socket = socket;
        try {
            this.idClient = idClient;
            messageFromServer = new ObjectInputStream(socket.getInputStream());
            writeMessage = new ObjectOutputStream(socket.getOutputStream());
            userHandler = new UserDataHandler(idClient, socket, database, messageFromServer, writeMessage);
            passportHandler = new PassportDataHandler(idClient, socket, database, messageFromServer, writeMessage);
            employeeHandler = new EmployeeDataHandler(idClient, socket, database, messageFromServer, writeMessage);
            carBrandHandler = new CarBrandDataHandler(idClient, socket, database, messageFromServer, writeMessage);
            carHandler = new CarDataHandler(idClient, socket, database, messageFromServer, writeMessage);
            carModelHandler = new CarModelDataHandler(idClient, socket, database, messageFromServer, writeMessage);
            clientdataHandler = new ClientDataHandler(idClient, socket, database, messageFromServer, writeMessage);
            orderdataHandler = new OrderDataHandler(idClient, socket, database, messageFromServer, writeMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    @Override
    public void run() {
        try {
            userHandler();
        } catch (IOException e) {
            ServerConnection serverConnection  = new ServerConnection();
            ServerConnection.setCount(serverConnection.getCount()-1);
            System.out.println("\nКлиент " + (idClient+1) + " отключился");
            System.out.println("Общее количество клиентов: " + serverConnection.getCount());
        }
    }

    private void userHandler() throws IOException {
        while (true) {

            String command = null;
            try
            {
                command = (String) messageFromServer.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            switch (command)
            {
                case "Регистрация":
                    userHandler.addInDatabase();
                    passportHandler.addInDatabase();
                    employeeHandler.addInDatabase();
                    break;

                case "Вход":
                    String flagAndEmployeeID = userHandler.сheckInDatabase();
                    flagAndEmployeeID += " " + employeeHandler.GetEmployeeID(flagAndEmployeeID);
                    sendMessage(flagAndEmployeeID);
                    flagAndEmployeeID = null;
                    break;
                    
                case "Получить марки":
                    sendMessage(carBrandHandler.showAll());
                    break;

                case "Получить машины":
                    sendMessage(carHandler.showAll());
                    break;

                case "Получить фильтр машин":
                    sendMessage(carHandler.showAllbyFilter());
                    break;

                case "Получить модели":
                    sendMessage(carModelHandler.showAll());
                    break;

                case "Получить клиентов":
                    sendMessage(clientdataHandler.showAll());
                    break;

                case "Получить заказы":
                    sendMessage(orderdataHandler.showAll());
                    break;

                case "Получить заказы по id":
                    sendMessage(orderdataHandler.showAllById());
                    break;

                case "Добавление клиента":
                    passportHandler.addInDatabase();
                    clientdataHandler.addInDatabase();
                    break;

                case "Получить фильтр машин в наличии":
                    sendMessage(carHandler.showAllbyFilterAvail());
                    break;

                case "Получить машины в наличии":
                    sendMessage(carHandler.showAllAvail());
                    break;

                case "Получить фильтр клиентов":
                    sendMessage(clientdataHandler.showAllbyFilter());
                    break;

                case "Добавить новый заказ":
                    orderdataHandler.addInDatabase();
                    break;

                case "Изменить клиента":
                    clientdataHandler.changeInDatabase();
                    break;

                case "Удалить заказ":
                    orderdataHandler.delete();
                    break;

                case "Удалить клиента":
                    clientdataHandler.delete();
                    break;

                case "Получить количество заказов":
                    sendMessage(Integer.toString(orderdataHandler.getCount()));
                    break;

                case "Получить сотрудника по id":
                    sendMessage(employeeHandler.getEmployeeByid());
                    break;
            }
        }
    }

        public void sendMessage(String msg){
            try {
                writeMessage.writeObject(msg);
                writeMessage.flush();
            } catch (IOException ignored) {
            }
        }

    public void sendMessage(LinkedList<?> msg){
        try {
            writeMessage.writeObject(msg);
        } catch (IOException ignored) {
        }
    }

    public void sendMessage(Object msg){
        try {
            writeMessage.writeObject(msg);
        } catch (IOException ignored) {
        }
    }
    }