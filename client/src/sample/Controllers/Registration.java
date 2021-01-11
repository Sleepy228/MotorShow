package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sample.Classes.*;
import sample.ClientActions.Client;
import sample.Windows.Alerts;
import sample.Windows.NewWindowOpen;

import java.time.format.DateTimeParseException;

public class Registration {
    private static int flag = 0;

    private static User user;
    private static Passport passport;
    private static Employee employee;

    @FXML
    private TextField tLogin;

    @FXML
    private Button bRegistration;

    @FXML
    private TextField tPassportNumber;

    @FXML
    private TextField tName;

    @FXML
    private TextField tMiddleName;

    @FXML
    private TextField tPassword;

    @FXML
    private RadioButton rMan;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rWooMan;

    @FXML
    private DatePicker tDateOfBirth;

    @FXML
    private TextField tPosition;

    @FXML
    private TextField tSalary;

    @FXML
    private TextField tPassword2;

    @FXML
    private Button bBack;

    @FXML
    private TextField tSurname;

    @FXML
    private RadioButton rEmployee;

    @FXML
    private ToggleGroup role;

    @FXML
    private RadioButton rAdmin;


    @FXML
    void initialize()
    {
        if(flag == 0) return;
        if(flag == 1 || flag == 2)
        {
            tPassportNumber.setDisable(true);
        }
    }

    @FXML
    void clickRegistration(ActionEvent event)
    {
        User user = new User();
        Passport passport = new Passport();
        Employee employee = new Employee();

        try
        {
            if(tLogin.getText().equals("") || tPassword.getText().equals("") || tPassword2.getText().equals("")
                || tName.getText().equals("") || tMiddleName.getText().equals("") || tSurname.getText().equals("")
                || tPosition.getText().equals("") || tSalary.getText().equals("")  || tDateOfBirth.getValue().equals(""))
            {
                Alerts.SetAlert(false,"Не все поля заполнены");
                return;
            }

            if(!tPassword.getText().equals(tPassword2.getText()))
            {
                Alerts.SetAlert(false,"Пароли не совпадают");
                return;
            }

            user.setLogin(tLogin.getText());
            user.setPassword(tPassword.getText());
            if(flag == 0 || flag == 1) {
                if (rEmployee.isSelected()) user.setRole(1);
                else user.setRole(3);
            }
            else
            {
                if (rEmployee.isSelected()) user.setRole(1);
                else user.setRole(2);
            }

            passport.setName(tName.getText());
            passport.setSurname(tSurname.getText());
            passport.setMiddleName(tMiddleName.getText());
            if(rMan.isSelected()) passport.setGender(rMan.getText());
            else passport.setGender(rWooMan.getText());
            passport.setDateOfBirth(tDateOfBirth.getValue());
            passport.setPassportnumber(Integer.parseInt(tPassportNumber.getText()));

            employee.setPassportNumber(Integer.parseInt(tPassportNumber.getText()));
            employee.setPosition(tPosition.getText());
            employee.setSalary(Integer.parseInt(tSalary.getText()));

            if(flag == 0) {
                Client.interactionsWithServer.addNewUserInDataBase(user, passport, employee);
                Alerts.SetAlert(true,"Вы успешно зарегистрировались!");
            }
            else {
               //Client.interactionsWithServer.ChangeSelf(user, passport, employee);
                Alerts.SetAlert(true, "Вы успешно изменили запись!");
            }
            clickBack(event);
        }
        catch (Exception e)
        {
            Alerts.SetAlert(false, e.getMessage());
        }
    }

    @FXML
    void clickBack(ActionEvent event)
    {
        if (flag == 0) {
            NewWindowOpen windowOpen = new NewWindowOpen();
            windowOpen.openWindow(bBack, "../View/mainpage.fxml");
        }
        else if (flag == 1){
            NewWindowOpen windowOpen = new NewWindowOpen();
            windowOpen.openWindow(bBack, "../View/employeechangemenu.fxml");
        }
        else if (flag == 2)
        {
            NewWindowOpen windowOpen = new NewWindowOpen();
            windowOpen.openWindow(bBack, "../View/adminchangemenu.fxml");
        }
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
