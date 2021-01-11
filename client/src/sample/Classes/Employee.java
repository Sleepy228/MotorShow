package sample.Classes;

import java.io.Serializable;

public class Employee implements Serializable
{
    private int idEmployee;
    private String position;
    private int salary;
    private int PassportNumber;
    private int idUser;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        PassportNumber = passportNumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
