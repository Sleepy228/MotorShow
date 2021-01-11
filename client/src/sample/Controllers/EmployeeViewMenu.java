package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Windows.Loader;
import sample.Windows.NewWindowOpen;

public class EmployeeViewMenu {

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
    void clickExit(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeemenu.fxml");
    }

    @FXML
    void clickViewBrand(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewbrand.fxml");
    }

    @FXML
    void clickViewCar(ActionEvent event)
    {

        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewcar.fxml");
    }

    @FXML
    void clickViewClient(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/viewclient.fxml");
    }

    @FXML
    void clickViewModel(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewmodel.fxml");
    }

    @FXML
    void clickViewOrder(ActionEvent event)
    {
        Loader loader = new Loader();
        ViewOrder viewOrder = loader.loaderSet("/sample/View/vieworder.fxml").getController(); //получаем контроллер для второй формы
        viewOrder.setFlag(0);
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/vieworder.fxml");
    }

    @FXML
    void clickViewStatistics(ActionEvent event) {
        Loader loader = new Loader();
        Statistic statistic = loader.loaderSet("/sample/View/statistic.fxml").getController(); //получаем контроллер для второй формы
        statistic.setFlag(0);
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/statistic.fxml");

    }


}
