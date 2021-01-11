package Interfaces;

import sample.Classes.CarBrand;

import java.util.LinkedList;

public interface IObjectService {
    LinkedList<?> showAll();
    void delete();
    void addInDatabase();
    void changeInDatabase();
}
