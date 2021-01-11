package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Windows.Loader;
import sample.Windows.NewWindowOpen;

public class AdminViewMenu {

    @FXML
    private Button bExit;

    @FXML
    private Button bViewClient;

    @FXML
    private Button bViewOrder;

    @FXML
    private Button bViewCar;

    @FXML
    private Button bViewBrand;

    @FXML
    private Button bViewModel;

    @FXML
    private Button bViewStatistics;

    @FXML
    private Button bViewUser;

    @FXML
    private Button bViewPasport;

    @FXML
    private Button bViewEmployee;

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bViewBrand, "../View/adminmenu.fxml");
    }

    @FXML
    void clickViewBrand(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewbrand.fxml");
    }

    @FXML
    void clickViewCar(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewcar.fxml");
    }

    @FXML
    void clickViewClient(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/viewclient.fxml");
    }

    @FXML
    void clickViewEmployee(ActionEvent event) {

    }

    @FXML
    void clickViewModel(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewmodel.fxml");
    }

    @FXML
    void clickViewOrder(ActionEvent event) {
        Loader loader = new Loader();
        ViewOrder viewOrder = loader.loaderSet("/sample/View/vieworder.fxml").getController(); //получаем контроллер для второй формы
        viewOrder.setFlag(1);
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/vieworder.fxml");
    }

    @FXML
    void clickViewPasport(ActionEvent event) {

    }

    @FXML
    void clickViewStatistics(ActionEvent event) {

    }

    @FXML
    void clickViewUser(ActionEvent event) {

    }

}
