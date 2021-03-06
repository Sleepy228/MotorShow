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
import sample.Classes.ClientView;
import sample.ClientActions.Client;
import sample.Windows.NewWindowOpen;

import java.nio.file.LinkOption;
import java.time.LocalDate;

public class ViewClient {
    private static int flag = 0;

    @FXML
    private Button bExit;

    @FXML
    private TableView<ClientView> tableClient;

    @FXML
    private TableColumn<ClientView, Integer> cId;

    @FXML
    private TableColumn<ClientView, String> cGender;

    @FXML
    private TableColumn<ClientView, LocalDate> cDateOfBirth;

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
    void initialize()
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
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        tableClient.setItems(resSet);
    }

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        if (flag == 1)
    {
        windowOpen.openWindow(bExit, "../View/adminviewmenu.fxml");
    }
    else
    {
        windowOpen.openWindow(bExit, "../View/employeeviewmenu.fxml");
    }
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }

}
