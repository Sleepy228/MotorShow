package sample.Classes;

import java.io.Serializable;

public class CarModel implements Serializable
{
    private int idCarModel;
    private String model;
    private int idCarBrand;

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

    public int getIdCarBrand() {
        return idCarBrand;
    }

    public void setIdCarBrand(int idCarBrand) {
        this.idCarBrand = idCarBrand;
    }
}
