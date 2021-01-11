package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Windows.Loader;
import sample.Windows.NewWindowOpen;

public class EmployeeEditMenu {

    @FXML
    private Button bExit;

    @FXML
    private Button bEditClient;

    @FXML
    private Button bEditOrder;

    @FXML
    void clickEditClient(ActionEvent event) {
        Loader loader = new Loader();
        EditClient orderedit = loader.loaderSet("/sample/View/editclient.fxml").getController(); //получаем контроллер для второй формы
        orderedit.setFlag(0);
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEditClient, "../View/editclient.fxml");
    }

    @FXML
    void clickEditOrder(ActionEvent event) {
        Loader loader = new Loader();
        EditOrder editOrder = loader.loaderSet("/sample/View/editordermenu.fxml").getController(); //получаем контроллер для второй формы
        editOrder.setFlag(0);
        editOrder.setFilterString2(null);
        editOrder.setFilterString(null);

        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEditClient, "../View/editordermenu.fxml");
    }

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEditClient, "../View/employeemenu.fxml");
    }

}
