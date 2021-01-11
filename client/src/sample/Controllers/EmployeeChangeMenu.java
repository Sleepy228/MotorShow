package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Classes.Employee;
import sample.Classes.Passport;
import sample.Classes.User;
import sample.ClientActions.Client;
import sample.Windows.Loader;
import sample.Windows.NewWindowOpen;

public class EmployeeChangeMenu {
    private static int idEmployee;

    @FXML
    private Button bExit;

    @FXML
    private Button bVChangeClient;

    @FXML
    private Button bChangeSelf;

    @FXML
    void clickChangClient(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bChangeSelf, "../View/changeclient.fxml");
    }


    @FXML
    void clickChangeSelf(ActionEvent event)
    {
        Employee employee;
        Passport passport;
        User user;

        employee = Client.interactionsWithServer.giveEmployeeById(idEmployee);
        passport = Client.interactionsWithServer.givePassportByPassportNumber(employee.getPassportNumber());
        user = Client.interactionsWithServer.giveUserById(employee.getIdUser());

        Loader loader = new Loader();
        Registration registration = loader.loaderSet("/sample/View/selectchangeorder.fxml").getController();

        registration.setPassport(passport);
        registration.setUser(user);
        registration.setEmployee(employee);
        registration.setFlag(1);
    }

    @FXML
    void clickExit(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bChangeSelf, "../View/employeemenu.fxml");
    }

    public void setIdEmployee(Integer idEmployee)
    {
        this.idEmployee = idEmployee;
    }
}
