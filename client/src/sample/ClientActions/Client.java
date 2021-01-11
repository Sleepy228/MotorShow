package sample.ClientActions;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static ClientActionsWithServer interactionsWithServer;

    public void connectToServer() throws IOException {
        Socket clientSocket = new Socket("localhost", 2000);
        interactionsWithServer = new ClientActionsWithServer(clientSocket);

    }
}
