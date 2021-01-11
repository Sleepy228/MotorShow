package sample.Classes;

import java.io.Serializable;

public class CarBrand implements Serializable
{
    private int idCarBrand;
    private String brand;

    public int getIdCarBrand() {
        return idCarBrand;
    }

    public void setIdCarBrand(int idCarBrand) {
        this.idCarBrand = idCarBrand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
