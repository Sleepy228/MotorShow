package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import sample.Classes.User;
import sample.ClientActions.Client;
import sample.ClientActions.ClientActionsWithServer;
import sample.Windows.Alerts;
import sample.Windows.Loader;
import sample.Windows.NewWindowOpen;

public class MainController {

    @FXML
    private PasswordField tPassword;

    @FXML
    private TextField tLogin;

    @FXML
    private Button exitprogram;

    @FXML
    private Button bEnter;

    @FXML
    private Button bRegistration;

    @FXML
    void clickEnter(ActionEvent event)
    {
        User user = new User();
        int flag = -1;
        int idEmployee = 0;

        if (tLogin.getText().equals("") || tPassword.getText().equals(""))
        {
            Alerts.SetAlert(false, "Введены не все данные");
            return;
        }

        user.setLogin(tLogin.getText());
        user.setPassword(tPassword.getText());


        String flagAndId = Client.interactionsWithServer.CheckUserInDataBase(user);
        String [] strings = flagAndId.split(" ");
        flag = Integer.parseInt(strings[0]);
        idEmployee = Integer.parseInt(strings[2]);

        if (flag == 1) {
            Loader loader = new Loader();

            ViewOrder viewOrder = loader.loaderSet("/sample/View/vieworder.fxml").getController(); //получаем контроллер для второй формы
            viewOrder.setFlag(0);
            viewOrder.setId(idEmployee);

            ViewClient viewclient = loader.loaderSet("/sample/View/viewclient.fxml").getController();
            viewclient.setFlag(0);

            EditClient editClient = loader.loaderSet("/sample/View/editclient.fxml").getController();
            editClient.setFlag(0);

            OrderEdit orderEdit = loader.loaderSet("/sample/View/editorder.fxml").getController();
            orderEdit.setIdEmployee(idEmployee);

            DeleteOrder deleteOrder = loader.loaderSet("/sample/View/deleteorder.fxml").getController();
            deleteOrder.setId(idEmployee);

            SelectChangeOrder selectChangeOrder = loader.loaderSet("/sample/View/selectchangeorder.fxml").getController();
            selectChangeOrder.setFlag(0);
            selectChangeOrder.setId(idEmployee);

            EmployeeChangeMenu employeeChangeMenu = loader.loaderSet("/sample/View/employeechangemenu.fxml").getController();
            selectChangeOrder.setId(idEmployee);

            Statistic statistic = loader.loaderSet("/sample/View/statistic.fxml").getController();
            statistic.setIdEmployee(idEmployee);

            NewWindowOpen windowOpen = new NewWindowOpen();
            windowOpen.openWindow(bEnter, "../View/employeemenu.fxml");
        }
        else if (flag == 2) {
            NewWindowOpen windowOpen = new NewWindowOpen();
            windowOpen.openWindow(bEnter, "../View/adminmenu.fxml");
        }
        else if (flag == -1 || flag > 3)
        {
            Alerts.SetAlert(false, "Пользователь не найден, проверьте введенные данные");
            return;
        }
        else if(flag == 3)
        {
            Alerts.SetAlert(false, "Для того, чтобы зайти первый раз в качестве администратора, необходимо, чтобы другой администратор утвердил вас");
            return;
        }
    }

    @FXML
    void clickRegistration(ActionEvent event)
    {
        Loader loader = new Loader();
        Registration registration = loader.loaderSet("/sample/View/registration.fxml").getController();
        registration.setFlag(0);

        NewWindowOpen windowOpen = new NewWindowOpen();
        windowOpen.openWindow(bEnter, "../View/registration.fxml");
    }

    @FXML
    void clickexitprogram(ActionEvent event)
    {
        System.exit(0);
    }
}
