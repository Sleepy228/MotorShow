package sample.Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Passport  implements Serializable
{
    private int passportnumber;
    private String name;
    private String surname;
    private String middleName;
    private String gender;
    private LocalDate dateOfBirth;

    public int getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(int passportnumber) {
        this.passportnumber = passportnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
