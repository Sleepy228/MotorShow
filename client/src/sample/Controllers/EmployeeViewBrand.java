package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.CarBrand;
import sample.Classes.User;
import sample.ClientActions.Client;
import sample.Windows.NewWindowOpen;

import java.util.LinkedList;

public class EmployeeViewBrand {

    @FXML
    private Button bExit;

    @FXML
    private TableView<CarBrand> tableBrand;

    @FXML
    private TableColumn<CarBrand, Integer> cId;

    @FXML
    private TableColumn<CarBrand, String> cBrand;

    @FXML
    void initialize()
    {
        ObservableList<CarBrand>  resSet;
        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveCarBrands());

        cId.setCellValueFactory(new PropertyValueFactory<>("idCarBrand"));
        cBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        tableBrand.setItems(resSet);
    }

    @FXML
    void clickExit(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewmenu.fxml");
    }

}
