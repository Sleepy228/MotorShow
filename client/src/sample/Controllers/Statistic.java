package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.ClientActions.Client;
import sample.Windows.Alerts;
import sample.Windows.NewWindowOpen;

public class Statistic {

    private static int flag = 0;

    @FXML
    private Button bExit;

    @FXML
    private Button bGiveStatistic;

    @FXML
    private Button bGiveReport;

    @FXML
    private BarChart<String, Integer> chart;

    @FXML
    private DatePicker tdate;

    @FXML
    private static int idEmployee;

    @FXML
    private TextField tidEmployee;

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

    @FXML
    void initialize() {

        chart.getXAxis().setLabel("Сотрудники");
        chart.getYAxis().setLabel("Колличество продаж");

    }

    @FXML
    void clickGiveStatistic(ActionEvent event) {
        if(tdate.getValue() == null) {
            Alerts.SetAlert(false, "Вы не выбрали дату");
        }

        String dateAndId = tdate.getValue().toString() + " " + idEmployee;

        int count1 = Client.interactionsWithServer.giveCount(dateAndId);

        dateAndId = tdate.getValue().toString() + " " + (idEmployee-1);
        int count2 = Client.interactionsWithServer.giveCount(dateAndId);

        XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series<String, Integer>();
        dataSeries1.setName(tdate.getValue().toString());

        dataSeries1.getData().add(new XYChart.Data<String, Integer>("сотрудник 1", count1));
        dataSeries1.getData().add(new XYChart.Data<String, Integer>("Другой сотрудник", count2));

        // Add Series to BarChart.
        chart.getData().add(dataSeries1);
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }

    public void setIdEmployee(Integer idEmployee)
    {
        this.idEmployee = idEmployee;
    }
}
