package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.Classes.CarView;
import sample.Classes.ClientView;
import sample.Classes.Order;
import sample.ClientActions.Client;
import sample.Windows.Alerts;
import sample.Windows.NewWindowOpen;

public class OrderEdit {
    private static ClientView client;
    private static CarView car;
    private static int idEmployee;
    @FXML
    private Button bEdit;

    @FXML
    private TextField tVIN;

    @FXML
    private TextField tModel;

    @FXML
    private TextField tPower;

    @FXML
    private TextField tColor;

    @FXML
    private TextField tBodyType;

    @FXML
    private Button bBack;

    @FXML
    private TextField tBrand;

    @FXML
    private TextField tPrice;

    @FXML
    private TextField tid;

    @FXML
    private TextField tName;

    @FXML
    private TextField tMiddleName;

    @FXML
    private DatePicker tDateOfSale;

    @FXML
    private TextField tEmail;

    @FXML
    private TextField tNumber;

    @FXML
    private TextField tSurname;

    @FXML
    private TextField tAddress;

    @FXML
    private TextField tDateOfRelease;

    @FXML
    void initialize()
    {
        tName.setText(client.getName());
        tSurname.setText(client.getSurname());
        tMiddleName.setText(client.getMiddlename());
        tEmail.setText(client.getEmail());
        tid.setText(Integer.toString(client.getIdClient()));
        tNumber.setText(Long.toString(client.getPhone()));
        tAddress.setText(client.getAddress());
        tVIN.setText(Integer.toString(car.getVIN()));
        tBodyType.setText(car.getBodyType());
        tBrand.setText(car.getBrand());
        tColor.setText(car.getColor());
        tDateOfRelease.setText(car.getDateOfRelease().toString());
        tModel.setText(car.getModel());
        tPower.setText(Integer.toString(car.getPower()));
        tPrice.setText(Integer.toString(car.getPrice()));
    }


    @FXML
    void clickBack(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEdit, "../View/editordermenu.fxml");
    }

    @FXML
    void clickbEdit(ActionEvent event)
    {
        if(tDateOfSale.getValue() == null) {
            Alerts.SetAlert(false, "Вы не выбрали дату совершения сделки");
            return;
        }
        Order order = new Order();
        order.setDateOfSale(tDateOfSale.getValue());
        order.setIdClient(client.getIdClient());
        order.setVIN(car.getVIN());
        order.setIdEmployee(idEmployee);
        Client.interactionsWithServer.addNewOrderInDataBase(order);
        Alerts.SetAlert(true, "Заказ успешно добавлен");
        clickBack(event);
    }

    public void setClient(ClientView client) {
        this.client = client;
    }

    public void setCar(CarView car) {
        this.car = car;
    }

    public void setIdEmployee(int idEmployee)
    {
        this.idEmployee = idEmployee;
    }
}
