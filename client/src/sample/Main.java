package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.ClientActions.Client;
import sample.Windows.Alerts;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/mainpage.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 562, 350));
        primaryStage.show();
        Client client = new Client();
        while (true) {
            try {
                client.connectToServer();
                break;
            } catch (IOException e) {
                Alerts.SetAlert(false, "Сервер еще не запущен");
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
