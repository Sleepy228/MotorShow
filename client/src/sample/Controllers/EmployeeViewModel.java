package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.CarModelView;
import sample.Classes.CarView;
import sample.ClientActions.Client;
import sample.Windows.NewWindowOpen;

public class EmployeeViewModel {

    @FXML
    private Button bExit;

    @FXML
    private TableView<CarModelView> tableModel;

    @FXML
    private TableColumn<CarModelView, Integer> cId;

    @FXML
    private TableColumn<CarModelView, String> cBrand;

    @FXML
    private TableColumn<CarModelView, String> cModel;

    @FXML
    void initialize()
    {
        ObservableList<CarModelView> resSet;
        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveModels());

        cId.setCellValueFactory(new PropertyValueFactory<>("idCarModel"));
        cBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        cModel.setCellValueFactory(new PropertyValueFactory<>("model"));

        tableModel.setItems(resSet);
    }

    @FXML
    void clickExit(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewmenu.fxml");
    }

}
