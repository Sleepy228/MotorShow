package Constants;

public class Constants {
    public static final int PORT = 2000;

    public static final String  HOST_DATABASE ="localhost";
    public static final String  NAME_DATABASE ="motorshow";
    public static final String  USER_DATABASE ="root";
    public static final String  PORT_DATABASE ="3306";
    public static final String  PASSWORD_DATABASE ="root";

    public static final String USER_TABLE = "user";
    public static final String USER_IDUSER = "idUser";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ROLE = "role";

    public static final String PASSPORT_TABLE = "passport";
    public static final String PASSPORT_PASSPORTNUMBER = "passportNumber";
    public static final String PASSPORT_NAME = "name";
    public static final String PASSPORT_SURNAME = "surname";
    public static final String PASSPORT_MIDDLENAME = "middleName";
    public static final String PASSPORT_GENDER = "gender";
    public static final String PASSPORT_DATEOFBIRTH = "dateOfBirth";

    public static final String EMPLOYEE_TABLE = "employee";
    public static final String EMPLOYEE_IDEMPLOYEE = "idEmployee";
    public static final String EMPLOYEE_POSITION = "position";
    public static final String EMPLOYEE_SALARY = "salary";
    public static final String EMPLOYEE_PASSPORTNUMBER = "Passport_passportNumber";
    public static final String EMPLOYEE_IDUSER = "User_idUser";

    public static final String CLIENT_TABLE = "client";
    public static final String CLIENT_IDCLIENT = "idClient";
    public static final String CLIENT_ADDRESS = "address";
    public static final String CLIENT_EMAIL = "email";
    public static final String CLIENT_PHONE = "phone";
    public static final String CLIENT_PASSPORTNUMBER = "Passport_passportNumber";

    public static final String ORDER_TABLE = "order";
    public static final String ORDER_IDORDER = "idOrder";
    public static final String ORDER_DATEOFSALE = "DateOfSale";
    public static final String ORDER_IDEMPLOYEE = "Employee_idEmployee";
    public static final String ORDER_IDCLIENT= "Client_idClient";
    public static final String ORDER_CARVIN= "Car_VIN";

    public static final String CARBRAND_TABLE = "carBrand";
    public static final String CARBRAND_IDCARBRAND = "idCarBrand";
    public static final String CARBRAND_BRAND = "brand";

    public static final String CARMODEL_TABLE = "carModel";
    public static final String CARMODEL_IDCARMODEL = "idCarModel";
    public static final String CARMODEL_MODEL = "model";
    public static final String CARMODEL_IDCARBRAND = "CarBrand_idCarBrand";

    public static final String CAR_TABLE = "car";
    public static final String CAR_VIN = "VIN";
    public static final String CAR_POWER = "power";
    public static final String CAR_COLOR = "color";
    public static final String CAR_DATEOFRELEASE = "dateOfRelease";
    public static final String CAR_BODYTYPE = "bodyType";
    public static final String CAR_PRICE = "price";
    public static final String CAR_IDCARMODEL = "CarModel_idCarModel";


}
