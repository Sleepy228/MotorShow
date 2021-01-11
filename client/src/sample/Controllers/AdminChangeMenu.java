package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Windows.NewWindowOpen;

public class AdminChangeMenu {

    @FXML
    private Button bExit;

    @FXML
    private Button bVChangeClient;

    @FXML
    private Button bChangeOrder;

    @FXML
    private Button bChangeCar;

    @FXML
    private Button bChangeBrand;

    @FXML
    private Button bChangeModel;

    @FXML
    private Button bChangeSelf;

    @FXML
    private Button bChangeUser;

    @FXML
    private Button bChangePassport;

    @FXML
    private Button bChangeEmployee;

    @FXML
    void clickChangClient(ActionEvent event) {

    }

    @FXML
    void clickChangeBrand(ActionEvent event) {

    }

    @FXML
    void clickChangeCar(ActionEvent event) {

    }

    @FXML
    void clickChangeEmployee(ActionEvent event) {

    }

    @FXML
    void clickChangeModel(ActionEvent event) {

    }

    @FXML
    void clickChangeOrder(ActionEvent event) {

    }

    @FXML
    void clickChangePassport(ActionEvent event) {

    }

    @FXML
    void clickChangeSelf(ActionEvent event) {

    }

    @FXML
    void clickChangeUser(ActionEvent event) {

    }

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bChangeBrand, "../View/adminmenu.fxml");
    }

}
