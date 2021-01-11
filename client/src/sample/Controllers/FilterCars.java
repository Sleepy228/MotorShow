package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.Windows.Alerts;
import sample.Windows.Loader;
import sample.Windows.NewWindowOpen;

public class FilterCars {

    @FXML
    private TextField tValue;

    @FXML
    private Button bExit;

    @FXML
    private Button bFind;

    @FXML
    private ComboBox<String> cFilter;

    @FXML
    void initialize()
    {
        cFilter.setValue("VIN");
    }

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/editorder.fxml");
    }

    @FXML
    void clickFind(ActionEvent event) {
        if (tValue.getText().equals("")) {
            Alerts.SetAlert(false, "Не все поля заполнены");
            return;
        }
        Loader loader = new Loader();

        EditOrder editOrder = loader.loaderSet("/sample/View/editorder.fxml").getController(); //получаем контроллер для второй формы

        editOrder.setFilterString2(cFilter.getValue() + " " + tValue.getText());
        if(editOrder.getFilterString() != null) editOrder.setFlag(3);
        else editOrder.setFlag(1);

        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/editorder.fxml");
    }

}
