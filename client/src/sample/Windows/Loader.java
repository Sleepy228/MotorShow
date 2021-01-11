package sample.Windows;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Loader {
     public FXMLLoader loaderSet(String path)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));

        try
        { loader.load(); } catch (IOException e)
        {
            e.printStackTrace();
        }
        return loader;
    }
}
