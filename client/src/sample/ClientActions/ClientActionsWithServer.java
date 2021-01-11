package sample.ClientActions;

;
import sample.Classes.*;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class ClientActionsWithServer {

    private ObjectOutputStream sendMessage;
    private ObjectInputStream acceptMessage;
    private Socket clientSocket;


    public ClientActionsWithServer(Socket clientSocket) {
        try {
            sendMessage = new ObjectOutputStream(clientSocket.getOutputStream());
            acceptMessage = new ObjectInputStream(clientSocket.getInputStream());
            this.clientSocket = clientSocket;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void send(Object user) {
        try {
            sendMessage.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String text) {
        try {
            sendMessage.writeObject(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addNewUserInDataBase(User user, Passport passport, Employee employee) {
        send("Регистрация");
        send(user);
        send(passport);
        send(employee);
        send(user);
    }

    public void addNewOrderInDataBase(Order order)
    {
        send("Добавить новый заказ");
        send(order);
    }

    public String CheckUserInDataBase(User user) {
        send("Вход");
        send(user);
        try {
            return (String) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CarBrand> giveCarBrands() {
        send("Получить марки");
        try {
            return (LinkedList<CarBrand>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CarView> giveCars() {
        send("Получить машины");
        try {
            return (LinkedList<CarView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CarView> giveCarsAvail() {
        send("Получить машины в наличии");
        try {
            return (LinkedList<CarView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CarModelView> giveModels() {
        send("Получить модели");
        try {
            return (LinkedList<CarModelView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<ClientView> giveClients() {
        send("Получить клиентов");
        try {
            return (LinkedList<ClientView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<OrderView> giveOrders() {
        send("Получить заказы");
        try {
            return (LinkedList<OrderView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<OrderView> giveOrdersById(int id) {
        send("Получить заказы по id");
        send(Integer.toString(id));
        try {
            return (LinkedList<OrderView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNewClientInDataBase(sample.Classes.Client client, Passport passport) {
        send("Добавление клиента");
        send(passport);
        send(client);
    }

    public LinkedList<CarView> giveFilterCarsAvail(String filterString) {
        send("Получить фильтр машин в наличии");
        send(filterString);
        try {
            return (LinkedList<CarView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CarView> giveFilterCars(String filterString) {
        send("Получить фильтр машин");
        send(filterString);
        try {
            return (LinkedList<CarView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<ClientView>  giveFilterClients(String filterString) {
        send("Получить фильтр клиентов");
        send(filterString);
        try {
            return (LinkedList<ClientView>) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ChangeClientInDataBase(ClientView clientView)
    {
        send("Изменить клиента");
        send(clientView);
    }

    public void deleteOrder(OrderView orderView)
    {
        send("Удалить заказ");
        send(orderView);
    }

    public void deleteClient(ClientView clientView)
    {
        send("Удалить клиента");
        send(clientView);
    }

    public Employee giveEmployeeById(int idEmployee)
    {
        send("Получить сотрудника по id");
        send(idEmployee);
        try {
            return (Employee) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User giveUserById(int idUser)
    {
        send("Получить пользователя по id");
        send(idUser);
        try {
            return (User) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Passport givePassportByPassportNumber(int passportnumber)
    {
        send("Получить пользователя по id");
        send(passportnumber);
        try {
            return (Passport) acceptMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int giveCount(String dateAndId)
    {
        send("Получить количество заказов");
        send(dateAndId);
        try {
            return Integer.parseInt((String) acceptMessage.readObject()) ;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }



}

