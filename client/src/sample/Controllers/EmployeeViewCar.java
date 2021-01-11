package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.Car;
import sample.Classes.CarBrand;
import sample.Classes.CarView;
import sample.ClientActions.Client;
import sample.Windows.NewWindowOpen;

import java.time.LocalDate;

public class EmployeeViewCar {

    @FXML
    private Button bExit;

    @FXML
    private TableView<CarView> tableCar;

    @FXML
    private TableColumn<CarView, Integer> cVIN;

    @FXML
    private TableColumn<CarView, String> cBrand;

    @FXML
    private TableColumn<CarView, String> cmodel;

    @FXML
    private TableColumn<CarView, Integer> cPower;

    @FXML
    private TableColumn<CarView, String> cColor;

    @FXML
    private TableColumn<CarView, String> cBodyType;

    @FXML
    private TableColumn<CarView, LocalDate> cdateOfRelease;

    @FXML
    private TableColumn<CarView, Integer> cPrice;

    @FXML
    void initialize()
    {
        ObservableList<CarView> resSet;
        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveCars());

        cVIN.setCellValueFactory(new PropertyValueFactory<>("VIN"));
        cBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        cmodel.setCellValueFactory(new PropertyValueFactory<>("model"));
        cColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        cPower.setCellValueFactory(new PropertyValueFactory<>("power"));
        cBodyType.setCellValueFactory(new PropertyValueFactory<>("bodyType"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cdateOfRelease.setCellValueFactory(new PropertyValueFactory<>("dateOfRelease"));

        tableCar.setItems(resSet);
    }

    @FXML
    void clickExit(ActionEvent event)
    {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bExit, "../View/employeeviewmenu.fxml");
    }

}
