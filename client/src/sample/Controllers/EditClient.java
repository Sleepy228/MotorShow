package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Classes.Client;
import sample.Classes.ClientView;
import sample.Classes.Passport;
import sample.Windows.Alerts;
import sample.Windows.NewWindowOpen;

import javax.swing.text.LabelView;

public class EditClient {
    private static int flag = 0;
    private static ClientView clientView = new ClientView();
    @FXML
    private Button bEdit;

    @FXML
    private TextField tPassportNumber;

    @FXML
    private TextField tName;

    @FXML
    private TextField tMiddleName;

    @FXML
    private RadioButton rMan;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rWooMan;

    @FXML
    private DatePicker tDateOfBirth;

    @FXML
    private TextField tEmail;

    @FXML
    private TextField tNumber;

    @FXML
    private Button bBack;

    @FXML
    private TextField tSurname;

    @FXML
    private TextField tAddress;

    @FXML
    private Label text;

    @FXML
    public void initialize()
    {
        if (flag == 0 || flag == 1)
        {
            tPassportNumber.setEditable(true);
            text.setText("Добавление клиентов");
            bEdit.setText("Добавить");
        }
        else
        {
            tPassportNumber.setDisable(true);
            text.setText("Изменение клиентов");
            bEdit.setText("Изменить");
            tName.setText(clientView.getName());
            tSurname.setText(clientView.getSurname());
            tMiddleName.setText(clientView.getMiddlename());
            tEmail.setText(clientView.getEmail());
            tAddress.setText(clientView.getAddress());
            tNumber.setText(Long.toString(clientView.getPhone()));
            tDateOfBirth.setValue(clientView.getDateOfBirth());
            if (clientView.getGender().equals("Мужской")) rMan.setSelected(true);
            else rWooMan.setSelected(true);
        }
    }

    @FXML
    void clickBack(ActionEvent event) {
        NewWindowOpen windowOpen = new NewWindowOpen();
        if (flag == 0) windowOpen.openWindow(bBack, "../View/employeeeditmenu.fxml");
        if (flag == 1) windowOpen.openWindow(bBack, "../View/admineditmenu.fxml");
        if (flag == 2) windowOpen.openWindow(bBack, "../View/changeclient.fxml");
        if (flag == 3) windowOpen.openWindow(bBack, "../View/adminchangemenu.fxml");
    }

    @FXML
    void clickbEdit(ActionEvent event) {
        Passport passport = new Passport();
        Client client = new Client();

        try
        {
            if(flag == 0 || flag == 1) {
                if( tAddress.getText().equals("") || tEmail.getText().equals("") || tNumber.getText().equals("")
                        || tName.getText().equals("") || tMiddleName.getText().equals("") || tSurname.getText().equals("")
                        || tDateOfBirth.getValue().equals(""))
                {
                    Alerts.SetAlert(false,"Не все поля заполнены");
                    return;
                }

                passport.setName(tName.getText());
                passport.setSurname(tSurname.getText());
                passport.setMiddleName(tMiddleName.getText());
                if (rMan.isSelected()) passport.setGender(rMan.getText());
                else passport.setGender(rWooMan.getText());
                passport.setDateOfBirth(tDateOfBirth.getValue());
                passport.setPassportnumber(Integer.parseInt(tPassportNumber.getText()));

                client.setPassportNumber(Integer.parseInt(tPassportNumber.getText()));
                client.setAddress(tAddress.getText());
                client.setEmail(tEmail.getText());
                client.setPhone(Integer.parseInt(tNumber.getText()));

                sample.ClientActions.Client.interactionsWithServer.addNewClientInDataBase(client, passport);
                Alerts.SetAlert(true,"Вы успешно добавили клиента!");
                clickBack(event);
            }
            else {
                if( tAddress.getText().equals("") || tEmail.getText().equals("") || tNumber.getText().equals("")
                        || tName.getText().equals("") || tMiddleName.getText().equals("") || tSurname.getText().equals("") || tDateOfBirth.getValue().equals(""))
                {
                    Alerts.SetAlert(false,"Не все поля заполнены");
                    return;
                }
                clientView.setName(tName.getText());
                clientView.setMiddlename(tMiddleName.getText());
                clientView.setSurname(tSurname.getText());
                clientView.setEmail(tEmail.getText());
                clientView.setAddress(tAddress.getText());
                clientView.setPhone(Integer.parseInt(tNumber.getText()));
                if (rMan.isSelected()) clientView.setGender(rMan.getText());
                else clientView.setGender(rWooMan.getText());
                clientView.setDateOfBirth(tDateOfBirth.getValue());
                sample.ClientActions.Client.interactionsWithServer.ChangeClientInDataBase(clientView);
                Alerts.SetAlert(true,"Вы успешно изменили пользователя!");
                clickBack(event);
            }
        }
        catch (Exception e)
        {
            Alerts.SetAlert(false, e.getMessage());
        }
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }

    public void setClientView (ClientView clientView)
    {
        this.clientView = clientView;
    }

}
