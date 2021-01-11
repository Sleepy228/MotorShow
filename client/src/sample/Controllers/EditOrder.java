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
import sample.Classes.CarView;
import sample.Classes.ClientView;
import sample.ClientActions.Client;
import sample.Windows.Alerts;
import sample.Windows.Loader;
import sample.Windows.NewWindowOpen;

import java.time.LocalDate;

public class EditOrder {

    private static int flag;
    private static String filterString;
    private static String filterString2;

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
    private Button bExit;

    @FXML
    private Button bEditOrder;
    @FXML
    private TableView<ClientView> tableClient;

    @FXML
    private TableColumn<ClientView, Integer> cId;

    @FXML
    private TableColumn<ClientView, String> cSurname;

    @FXML
    private TableColumn<ClientView, String> cName;

    @FXML
    private TableColumn<ClientView, String> cMiddleName;

    @FXML
    private TableColumn<ClientView, Long> cPhone;

    @FXML
    private TableColumn<ClientView, String> cEmail;

    @FXML
    private TableColumn<ClientView, String> cAddress;

    @FXML
    private Button FindClient;

    @FXML
    private Button bFindCar;

    @FXML
    private Button bCancel;

    @FXML
    void initialize()
    {
        if  (flag == 1)
        {
            ViewAllCarsByFilter();
            ViewAllClients();
        }
        else if (flag == 2)
        {
            ViewAllClientsByFilter();
            ViewAllCars();
        }
        else if (flag == 3)
        {
            ViewAllCarsByFilter();
            ViewAllClientsByFilter();
        }
        else
        {
            ViewAllCars();
            ViewAllClients();
        }
    }

    @FXML
    void clickEditOrder(ActionEvent event)
    {
            try {
                ClientView clientView = tableClient.getSelectionModel().getSelectedItem();
                CarView carView = tableCar.getSelectionModel().getSelectedItem();
                Integer.toString(carView.getPrice());
                Integer.toString(clientView.getIdClient());

                Loader loader = new Loader();
                OrderEdit Orderedit = loader.loaderSet("/sample/View/editorder.fxml").getController(); //получаем контроллер для второй формы
                Orderedit.setClient(clientView);
                Orderedit.setCar(carView);

                NewWindowOpen windowOpen = new NewWindowOpen();
                windowOpen.openWindow(bEditOrder, "../View/editorder.fxml");
            }
            catch (Exception e)
            {
                Alerts.SetAlert(false, "Не все поля выбраны");
            }

    }

    @FXML
    void clickCancel(ActionEvent event)
    {
        flag = 0;
        filterString2 = null;
        filterString = null;
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEditOrder, "../View/editordermenu.fxml");
    }

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEditOrder, "../View/employeeeditmenu.fxml");
    }

    @FXML
    void clickFindCar(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEditOrder, "../View/filtercars.fxml");
    }

    @FXML
    void clickFindClient(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEditOrder, "../View/filterclients.fxml");
    }

    void ViewAllCars()
    {
        ObservableList<CarView> resSet;
        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveCarsAvail());

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

    void ViewAllClients()
    {
        ObservableList<ClientView> resSet;
        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveClients());

        cId.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        cSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        cMiddleName.setCellValueFactory(new PropertyValueFactory<>("middlename"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableClient.setItems(resSet);
    }

    void ViewAllCarsByFilter()
    {
        ObservableList<CarView> resSet;
        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveFilterCarsAvail(filterString2));

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

    void  ViewAllClientsByFilter()
    {
        ObservableList<ClientView> resSet;
        resSet = FXCollections.observableArrayList(Client.interactionsWithServer.giveFilterClients(filterString));

        cId.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        cSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        cMiddleName.setCellValueFactory(new PropertyValueFactory<>("middlename"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableClient.setItems(resSet);
    }


    public void setFlag(int flag) { this.flag = flag; }
    public int getFlag() {return flag; }

    public void setFilterString(String filterString) { this.filterString = filterString; }
    public String getFilterString() { return filterString; }
    public String getFilterString2() { return filterString2; }
    public void setFilterString2(String filterString) { this.filterString2 = filterString; }
}
