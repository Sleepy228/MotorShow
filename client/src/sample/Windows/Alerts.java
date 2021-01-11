package sample.Windows;

import javafx.scene.control.Alert;

public class Alerts {
    private  Alerts() {}
    private static Alert alert;
    private boolean flag;

    public static void SetAlert(boolean flag, String text)
    {
        if (alert == null) alert = new Alert(Alert.AlertType.INFORMATION);
        if (flag) alert.setTitle("Информация");
        else alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
