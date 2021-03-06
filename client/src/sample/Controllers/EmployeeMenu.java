package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Windows.NewWindowOpen;

public class EmployeeMenu {

    @FXML
    private Button bExit;

    @FXML
    private Button bEdit;

    @FXML
    private Button bView;

    @FXML
    private Button bChange;

    @FXML
    private Button bDelete;

    @FXML
    void clickChange(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeechangemenu.fxml");
    }

    @FXML
    void clickDelete(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeedeletemenu.fxml");
    }

    @FXML
    void clickEdit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeeditmenu.fxml");
    }

    @FXML
    void clickExit(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/mainpage.fxml");
    }

    @FXML
    void clickView(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewmenu.fxml");
    }

}
