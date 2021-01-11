package sample.Classes;

import java.io.Serializable;

public class CarModelView implements Serializable
{
    private int idCarModel;
    private String model;
    private String brand;

    public int getIdCarModel() {
        return idCarModel;
    }

    public void setIdCarModel(int idCarModel) {
        this.idCarModel = idCarModel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
