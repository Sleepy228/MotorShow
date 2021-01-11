package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Windows.NewWindowOpen;

public class AdminEditMenu {

    @FXML
    private Button bExit;

    @FXML
    private Button bEditClient;

    @FXML
    private Button bEditOrder;

    @FXML
    private Button bEditCar;

    @FXML
    private Button bEditBrand;

    @FXML
    private Button bVEditModel;

    @FXML
    private Button bEditUser;

    @FXML
    private Button bEditPassport;

    @FXML
    private Button bEditEmployee;

    @FXML
    void clickEditBrand(ActionEvent event) {

    }

    @FXML
    void clickEditCar(ActionEvent event) {

    }

    @FXML
    void clickEditClient(ActionEvent event) {

    }

    @FXML
    void clickEditEmployee(ActionEvent event) {

    }

    @FXML
    void clickEditModel(ActionEvent event) {

    }

    @FXML
    void clickEditOrder(ActionEvent event) {

    }

    @FXML
    void clickEditPassport(ActionEvent event) {

    }

    @FXML
    void clickEditUser(ActionEvent event) {

    }

    @FXML
    void clickExit(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEditBrand, "../View/adminmenu.fxml");
    }

}
