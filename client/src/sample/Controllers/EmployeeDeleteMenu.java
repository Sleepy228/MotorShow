package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Windows.Alerts;
import sample.Windows.Loader;
import sample.Windows.NewWindowOpen;

public class EmployeeDeleteMenu {

    @FXML
    private Button bExit;

    @FXML
    private Button bDeleteClient;

    @FXML
    private Button bDeleteOrder;

    @FXML
    void clickDeleteClient(ActionEvent event) {
        Loader loader = new Loader();
        DeleteClient deleteClient = loader.loaderSet("/sample/View/deleteclient.fxml").getController(); //получаем контроллер для второй формы
        deleteClient.setFlag(0);
        Alerts.SetAlert(true, "Внимание! При удалении клиента, удалятся все заказы, связанные с ним.");
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bDeleteClient, "../View/deleteclient.fxml");
    }

    @FXML
    void clickDeleteOrder(ActionEvent event) {
        Loader loader = new Loader();
        DeleteOrder deleteOrder = loader.loaderSet("/sample/View/deleteorder.fxml").getController(); //получаем контроллер для второй формы
        deleteOrder.setFlag(0);
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bDeleteClient, "../View/deleteorder.fxml");
    }

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bDeleteClient, "../View/employeemenu.fxml");
    }

}
