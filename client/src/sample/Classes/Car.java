package sample.Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Car implements Serializable
{
    private int VIN;
    private int power;
    private String color;
    private LocalDate dateOfRelease;
    private String bodyType;
    private int price;
    private int idCarModel;

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdCarModel() {
        return idCarModel;
    }

    public void setIdCarModel(int idCarModel) {
        this.idCarModel = idCarModel;
    }
}
