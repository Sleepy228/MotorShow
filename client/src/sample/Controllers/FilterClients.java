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

public class FilterClients {

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
        cFilter.setValue("idClient");
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
        EditOrder editOrder = loader.loaderSet("/sample/View/editordermenu.fxml").getController(); //получаем контроллер для второй формы

        if(editOrder.getFilterString2() != null) editOrder.setFlag(3);
        else editOrder.setFlag(2);
        editOrder.setFilterString(cFilter.getValue() + " " + tValue.getText());

        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/editordermenu.fxml");
    }

}
