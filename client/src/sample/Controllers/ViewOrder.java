package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.ClientView;
import sample.Classes.OrderView;
import sample.ClientActions.Client;
import sample.Windows.Alerts;
import sample.Windows.NewWindowOpen;
import sample.Windows.WorkWithFile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

public class ViewOrder {
    private static int idEmployee = 0;
    private static int flag = 0;
    @FXML
    private Button bExit;

    @FXML
    private TableView<OrderView> tableOrder;

    @FXML
    private TableColumn<OrderView, Integer> cId;

    @FXML
    private TableColumn<OrderView, String> cSurname;

    @FXML
    private TableColumn<OrderView, String> cName;

    @FXML
    private TableColumn<OrderView, Integer> cVIN;

    @FXML
    private TableColumn<OrderView, String> cBrand;

    @FXML
    private TableColumn<OrderView, String> cModel;

    @FXML
    private TableColumn<OrderView, LocalDate> cDateOfSale;

    @FXML
    private Button bGiveReport;

    @FXML
    private TextField tidEmployee;

    @FXML
    private Button bSelectOrder;

    @FXML
    void initialize() {
        ObservableList<OrderView> resSet;
        if (flag == 0) {
            resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveOrdersById(idEmployee));
            tidEmployee.setVisible(false);
            bSelectOrder.setVisible(false);
        } else {
            resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveOrders());
            tidEmployee.setVisible(true);
            bSelectOrder.setVisible(true);
        }
        cId.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        cSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        cVIN.setCellValueFactory(new PropertyValueFactory<>("vin"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        cModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        cDateOfSale.setCellValueFactory(new PropertyValueFactory<>("dateOfSale"));

        tableOrder.setItems(resSet);
    }

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        if (flag == 0) {
            windowOpen.openWindow(bExit, "../View/employeeviewmenu.fxml");
        }
        if (flag == 1) {
            windowOpen.openWindow(bExit, "../View/adminviewmenu.fxml");
        }

    }

    @FXML
    void clickSelectOrder(ActionEvent event)
    {
        ObservableList<OrderView> resSet;
        int id;
        try {
           id = Integer.parseInt(tidEmployee.getText());
        }
        catch (Exception e) {
            Alerts.SetAlert(false, e.getMessage());
        return;
        }

        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveOrdersById(id));

        cId.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        cSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        cVIN.setCellValueFactory(new PropertyValueFactory<>("vin"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        cModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        cDateOfSale.setCellValueFactory(new PropertyValueFactory<>("dateOfSale"));

        tableOrder.setItems(resSet);
    }

    @FXML
    void clickGiveReport(ActionEvent event)
    {
        String text = "";
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        for(OrderView order: tableOrder.getItems())
        {
            text += "|" + order.getIdEmployee() + "|" + "|" + order.getBrand() + "|" + order.getModel() + "|"+ order.getVin() + "|" + order.getSurname() + "|"
                    + order.getName() + "|" + order.getDateOfSale() + "|\n";

        }
        if(text.equals("")) return;
        WorkWithFile.WriteInFile(("D:\\Курсач\\server\\src\\clientfiles\\" + date +".txt"), text);
        Alerts.SetAlert(true, "Отчет успешно создан");
    }

    public void setId(int id)
    {
        this.idEmployee = id;
    }
    public void setFlag(int flag)
    {
        this.flag = flag;
    }

}
