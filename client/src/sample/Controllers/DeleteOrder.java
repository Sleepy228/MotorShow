package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.ClientView;
import sample.Classes.OrderView;
import sample.ClientActions.Client;
import sample.Windows.Alerts;
import sample.Windows.NewWindowOpen;

import java.time.LocalDate;

public class DeleteOrder {
    private static int idEmployee = 0;
    private static int flag = 0;

    @FXML
    private Button bExit;

    @FXML
    private Button bDeleteOrder;

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
    void initialize()
    {
        ObservableList<OrderView> resSet;
        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveOrdersById(idEmployee));

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
    void clickDeleteOrder(ActionEvent event)
    {
        try {
            OrderView orderView = tableOrder.getSelectionModel().getSelectedItem();
            orderView.getVin();
            sample.ClientActions.Client.interactionsWithServer.deleteOrder(orderView);
            Alerts.SetAlert(true, "Заказ успешно удален");
            NewWindowOpen windowOpen = new NewWindowOpen();
            windowOpen.openWindow(bDeleteOrder, "../View/deleteorder.fxml");
        }
        catch (Exception e)
        {
            Alerts.SetAlert(false, "Выберите заказ для удаления");
        }

    }
    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        if (flag == 0)
        {
            windowOpen.openWindow(bExit, "../View/employeedeletemenu.fxml");
        }
        if (flag == 1)
        {
            windowOpen.openWindow(bExit, "../View/admindeletemenu.fxml");
        }

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
