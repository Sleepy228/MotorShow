package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Windows.NewWindowOpen;

public class AdminDeleteMenu {

    @FXML
    private Button bExit;

    @FXML
    private Button bDeleteClient;

    @FXML
    private Button bDeleteOrder;

    @FXML
    private Button bDeleteCar;

    @FXML
    private Button bDeleteBrand;

    @FXML
    private Button bDeleteModel;

    @FXML
    private Button bDeleteUser;

    @FXML
    private Button bDeletePassport;

    @FXML
    private Button bDeleteEmployee;

    @FXML
    void clickDeleteBrand(ActionEvent event) {

    }

    @FXML
    void clickDeleteCar(ActionEvent event) {

    }

    @FXML
    void clickDeleteClient(ActionEvent event) {

    }

    @FXML
    void clickDeleteEmployee(ActionEvent event) {

    }

    @FXML
    void clickDeleteModel(ActionEvent event) {

    }

    @FXML
    void clickDeleteOrder(ActionEvent event) {

    }

    @FXML
    void clickDeletePassport(ActionEvent event) {

    }

    @FXML
    void clickDeleteUser(ActionEvent event) {

    }

    @FXML
    void clickExit(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bDeleteBrand, "../View/adminmenu.fxml");
    }

}
