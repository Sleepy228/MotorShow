package Server;

import Constants.*;
import Database.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerConnection {
    public static LinkedList<ClientHandler> usersConnected = new LinkedList<>();
    private  int idClient = 0;
    private static int count = 0;

    private ServerSocket server;

    public void startServer(){
        try {
            server = new ServerSocket(2000);
            System.out.println("сервер запущен....\nIP: " + server.getInetAddress() + "\nPort: " + server.getLocalPort()
                    + "\n\nожидаем подключение....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void connectNewClientInToServer(){
        Database dataBaseHandler = new Database();

        try {
            while (true) {
                Socket socket = server.accept();

                usersConnected.add(new ClientHandler(socket,dataBaseHandler,idClient++));
                count += 1;
                System.out.println("\nклиент " + idClient + " подключился\n" + "Общее количество клиентов: " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeAll(){
        try {

            server.close();
            System.out.println("Сервер остановился !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ServerConnection.count = count;
    }
}
