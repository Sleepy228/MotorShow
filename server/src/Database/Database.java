package Database;

import sample.Classes.*;
import Constants.*;

import java.sql.*;
import java.util.LinkedList;

public class Database
{
    Connection dbConnection;
    Statement statement;
     private final char dm = (char) 34;

    public Database()
    {
        connectionToDB();
    }

    public void connectionToDB()
    {
        String connectionString = "jdbc:mysql://" + Constants.HOST_DATABASE + ":" + Constants.PORT_DATABASE + "/" + Constants.NAME_DATABASE;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString, Constants.USER_DATABASE, Constants.PASSWORD_DATABASE);
            statement = dbConnection.createStatement();
        }catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void WriteUser(User user)
    {
        String insert = "INSERT INTO " + Constants.USER_TABLE + " (" + Constants.USER_LOGIN + "," +
                Constants.USER_PASSWORD + "," + Constants.USER_ROLE + ") " +
                "VALUES (?,?,?)";

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            prSt.setInt(3, user.getRole());
            prSt.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void WriteClient(Client client)
    {
        String insert = "INSERT INTO " + Constants.CLIENT_TABLE + " (" + Constants.CLIENT_ADDRESS + "," +
                Constants.CLIENT_EMAIL + "," + Constants.CLIENT_PASSPORTNUMBER + "," + Constants.CLIENT_PHONE + ") " +
                "VALUES (?,?,?,?)";

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setString(1, client.getAddress());
            prSt.setString(2, client.getEmail());
            prSt.setInt(3, client.getPassportNumber());
            prSt.setInt(4, client.getPhone());
            prSt.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }


    public LinkedList<User> SelectAllUsers()
    {
        int id = 0;
        LinkedList<User> users = new LinkedList<>();
        User user = new User();
        String select = "SELECT * FROM " + Constants.USER_TABLE;
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                user.setId(Integer.parseInt(rs.getString(Constants.USER_IDUSER)));
                user.setLogin(rs.getString(Constants.USER_LOGIN));
                user.setPassword(rs.getString(Constants.USER_PASSWORD));
                user.setRole(Integer.parseInt(rs.getString(Constants.USER_ROLE)));
                users.add(user);
                user = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return users;
    }

    public int findUserId(String login)
    {
        User user = new User();
        String select = "SELECT * FROM " + Constants.USER_TABLE + " WHERE login=" + dm + login + dm;
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                user.setId(Integer.parseInt(rs.getString(Constants.USER_IDUSER)));
                user.setLogin(rs.getString(Constants.USER_LOGIN));
                user.setPassword(rs.getString(Constants.USER_PASSWORD));
                user.setRole(Integer.parseInt(rs.getString(Constants.USER_ROLE)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return user.getId();
    }

    public String CheckUserInDatabase(User user)
    {
        User user1 = new User();
        int flag = 0;

        String select = "SELECT * FROM " + Constants.USER_TABLE + " WHERE login=" + dm + user.getLogin() + dm
                + " AND password=" + dm + user.getPassword() + dm;
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();
            String flagAndId;
            while (rs.next())
            {
                user1.setId(Integer.parseInt(rs.getString(Constants.USER_IDUSER)));
                user1.setLogin(rs.getString(Constants.USER_LOGIN));
                user1.setPassword(rs.getString(Constants.USER_PASSWORD));
                user1.setRole(Integer.parseInt(rs.getString(Constants.USER_ROLE)));
            }
            if (user1.getRole() == 0) flag = 4;
            else if(user1.getRole() == 1) flag = 1;
            else if(user1.getRole() == 2) flag = 2;
            else if(user1.getRole() == 3) flag = 3;
            flagAndId = (flag + " " + user1.getId());
            return flagAndId;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "4 0";
        }

    }

    public String GetEmployeeID(String idUser)
    {
        Employee employee = new Employee();
        int flag = 0;

        String select = "SELECT * FROM " + Constants.EMPLOYEE_TABLE+ " WHERE User_idUser="  + idUser;
        ResultSet rs = null;
        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();
            String flagAndId;
            while (rs.next())
            {
                employee.setIdUser(Integer.parseInt(rs.getString(Constants.EMPLOYEE_IDUSER)));
                employee.setSalary(Integer.parseInt(rs.getString(Constants.EMPLOYEE_SALARY)));
                employee.setPassportNumber(Integer.parseInt(rs.getString(Constants.EMPLOYEE_PASSPORTNUMBER)));
                employee.setIdEmployee(Integer.parseInt(rs.getString(Constants.EMPLOYEE_IDEMPLOYEE)));
                employee.setPosition(rs.getString(Constants.EMPLOYEE_POSITION));
            }
            return Integer.toString(employee.getIdEmployee());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "0";
        }

    }


    public void WritePassport(Passport passport)
    {
        String insert = "INSERT INTO " + Constants.PASSPORT_TABLE + " (" + Constants.PASSPORT_PASSPORTNUMBER + "," +
                Constants.PASSPORT_NAME + "," + Constants.PASSPORT_SURNAME + "," + Constants.PASSPORT_MIDDLENAME +
        "," + Constants.PASSPORT_GENDER + "," + Constants.PASSPORT_DATEOFBIRTH + ") " + "VALUES (?,?,?,?,?,?)";

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setInt(1, passport.getPassportnumber());
            prSt.setString(2, passport.getName());
            prSt.setString(3, passport.getSurname());
            prSt.setString(4, passport.getMiddleName());
            prSt.setString(5, passport.getGender());
            prSt.setString(6, passport.getDateOfBirth().toString());
            prSt.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void WriteEmployee(Employee employee)
    {
        String insert = "INSERT INTO " + Constants.EMPLOYEE_TABLE + " (" + Constants.EMPLOYEE_IDUSER + "," +
                Constants.EMPLOYEE_PASSPORTNUMBER + "," + Constants.EMPLOYEE_POSITION + "," + Constants.EMPLOYEE_SALARY
                + ") " + "VALUES (?,?,?,?)";

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setInt(1, employee.getIdUser());
            prSt.setInt(2, employee.getPassportNumber());
            prSt.setString(3, employee.getPosition());
            prSt.setInt(4, employee.getSalary());
            prSt.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

     public void WriteOrder(Order order)
     {
         String insert = "INSERT INTO " +"`motorshow`.`order`"+ " (" + Constants.ORDER_CARVIN + "," +
                 Constants.ORDER_DATEOFSALE + "," + Constants.ORDER_IDCLIENT + "," + Constants.ORDER_IDEMPLOYEE
                 + ") " + "VALUES (?,?,?,?)";
         try
         {
             PreparedStatement prSt = dbConnection.prepareStatement(insert);
             prSt.setInt(1, order.getVIN());
             prSt.setString(2, order.getDateOfSale().toString());
             prSt.setInt(3, order.getIdClient());
             prSt.setInt(4, order.getIdEmployee());
             prSt.executeUpdate();
         }
         catch (SQLException throwables)
         {
             throwables.printStackTrace();
         }
     }

    public LinkedList<CarBrand> SelectAllCarBrand()
    {
        LinkedList<CarBrand> carBrands = new LinkedList<>();

        String select = "SELECT * FROM " + Constants.CARBRAND_TABLE;
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                CarBrand carBrand = new CarBrand();
                carBrand.setIdCarBrand(rs.getInt(Constants.CARBRAND_IDCARBRAND));
                carBrand.setBrand(rs.getString(Constants.CARBRAND_BRAND));
                carBrands.add(carBrand);
                carBrand = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return carBrands;
    }

    public LinkedList<CarView> SelectAllCar()
    {
        LinkedList<CarView> cars = new LinkedList<>();

        String select = "SELECT carbrand.brand, carmodel.model, car.VIN, car.power, car.color, car.bodyType, " +
                "car.dateofRelease, car.price " +
                "from car " +
                "join carmodel on CarModel_idCarModel = idCarModel " +
                "join carbrand on CarBrand_idCarBrand = idCarBrand";
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                CarView car = new CarView();
                car.setVIN(rs.getInt(Constants.CAR_VIN));
                car.setBrand(rs.getString(Constants.CARBRAND_BRAND));
                car.setModel(rs.getString(Constants.CARMODEL_MODEL));
                car.setBodyType(rs.getString(Constants.CAR_BODYTYPE));
                car.setColor(rs.getString(Constants.CAR_COLOR));
                car.setPrice(rs.getInt(Constants.CAR_PRICE));
                car.setDateOfRelease(rs.getDate(Constants.CAR_DATEOFRELEASE).toLocalDate());
                car.setPower(rs.getInt(Constants.CAR_POWER));
                cars.add(car);
                car = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return cars;
    }


    public LinkedList<CarView> SelectAllCarAvail()
    {
        LinkedList<CarView> cars = new LinkedList<>();

        String select = "SELECT carbrand.brand, carmodel.model, car.VIN, " +
                "car.power, car.color, car.bodyType, " +
                "car.dateofRelease, car.price " +
                "from car " +
                "left join motorshow.order on car.VIN = motorshow.order.Car_VIN " +
                "join carmodel on CarModel_idCarModel = idCarModel " +
                "join carbrand on CarBrand_idCarBrand = idCarBrand " +
                "where motorshow.order.Car_VIN is null";
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                CarView car = new CarView();
                car.setVIN(rs.getInt(Constants.CAR_VIN));
                car.setBrand(rs.getString(Constants.CARBRAND_BRAND));
                car.setModel(rs.getString(Constants.CARMODEL_MODEL));
                car.setBodyType(rs.getString(Constants.CAR_BODYTYPE));
                car.setColor(rs.getString(Constants.CAR_COLOR));
                car.setPrice(rs.getInt(Constants.CAR_PRICE));
                car.setDateOfRelease(rs.getDate(Constants.CAR_DATEOFRELEASE).toLocalDate());
                car.setPower(rs.getInt(Constants.CAR_POWER));
                cars.add(car);
                car = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return cars;
    }

    public LinkedList<CarView> SelectAllCarByFilter(String filterstring)
    {
        LinkedList<CarView> cars = new LinkedList<>();
        String [] strings = filterstring.split(" ");
        String namebyfilter = strings[0];
        String value = strings[1];

        String select = "SELECT carbrand.brand, carmodel.model, car.VIN, car.power, car.color, car.bodyType, " +
                "car.dateofRelease, car.price " +
                "from car " +
                "join carmodel on CarModel_idCarModel = idCarModel " +
                "join carbrand on CarBrand_idCarBrand = idCarBrand " +
                "WHERE " + namebyfilter + "=" + value;
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                CarView car = new CarView();
                car.setVIN(rs.getInt(Constants.CAR_VIN));
                car.setBrand(rs.getString(Constants.CARBRAND_BRAND));
                car.setModel(rs.getString(Constants.CARMODEL_MODEL));
                car.setBodyType(rs.getString(Constants.CAR_BODYTYPE));
                car.setColor(rs.getString(Constants.CAR_COLOR));
                car.setPrice(rs.getInt(Constants.CAR_PRICE));
                car.setDateOfRelease(rs.getDate(Constants.CAR_DATEOFRELEASE).toLocalDate());
                car.setPower(rs.getInt(Constants.CAR_POWER));
                cars.add(car);
                car = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return cars;
    }

    public LinkedList<CarView> SelectAllCarByFilterAvail(String filterstring)
    {
        LinkedList<CarView> cars = new LinkedList<>();
        String [] strings = filterstring.split(" ");
        String namebyfilter = strings[0];
        String value = strings[1];

        String select = "SELECT carbrand.brand, carmodel.model, car.VIN, car.power, car.color, car.bodyType, " +
                "car.dateofRelease, car.price " +
                "from car " +
                "left join motorshow.order on car.VIN = motorshow.order.Car_VIN " +
                "join carmodel on CarModel_idCarModel = idCarModel " +
                "join carbrand on CarBrand_idCarBrand = idCarBrand " +
                "WHERE " +  namebyfilter + "=" + value + " and motorshow.order.Car_VIN is null";
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                CarView car = new CarView();
                car.setVIN(rs.getInt(Constants.CAR_VIN));
                car.setBrand(rs.getString(Constants.CARBRAND_BRAND));
                car.setModel(rs.getString(Constants.CARMODEL_MODEL));
                car.setBodyType(rs.getString(Constants.CAR_BODYTYPE));
                car.setColor(rs.getString(Constants.CAR_COLOR));
                car.setPrice(rs.getInt(Constants.CAR_PRICE));
                car.setDateOfRelease(rs.getDate(Constants.CAR_DATEOFRELEASE).toLocalDate());
                car.setPower(rs.getInt(Constants.CAR_POWER));
                cars.add(car);
                car = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return cars;
    }


    public LinkedList<CarModelView> SelectAllModel()
    {
        LinkedList<CarModelView> models = new LinkedList<>();

        String select = "SELECT carmodel.idCarModel, carbrand.brand, carmodel.model " +
                "from carmodel " +
                "join carbrand on CarBrand_idCarBrand = idCarBrand";
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                CarModelView model = new CarModelView();

                model.setIdCarModel(rs.getInt(Constants.CARMODEL_IDCARMODEL));
                model.setBrand(rs.getString(Constants.CARBRAND_BRAND));
                model.setModel(rs.getString(Constants.CARMODEL_MODEL));

                models.add(model);
                model = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return models;
    }

    public LinkedList<ClientView> SelectAllClients()
    {
        LinkedList<ClientView> clients = new LinkedList<>();

        String select = "SELECT passport.surname, passport.name, passport.middlename, passport.gender, passport.dateOfBirth, " +
                "client.idClient, client.address, client.email, client.phone " +
                "from client " +
                "join passport on Passport_passportNumber = passportNumber";
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                ClientView client = new ClientView();

                client.setIdClient(rs.getInt(Constants.CLIENT_IDCLIENT));
                client.setAddress(rs.getString(Constants.CLIENT_ADDRESS));
                client.setEmail(rs.getString(Constants.CLIENT_EMAIL));
                client.setPhone(rs.getLong(Constants.CLIENT_PHONE));
                client.setName(rs.getString(Constants.PASSPORT_NAME));
                client.setSurname(rs.getString(Constants.PASSPORT_SURNAME));
                client.setMiddlename(rs.getString(Constants.PASSPORT_MIDDLENAME));
                client.setGender(rs.getString(Constants.PASSPORT_GENDER));
                client.setDateOfBirth(rs.getDate(Constants.PASSPORT_DATEOFBIRTH).toLocalDate());
                clients.add(client);
                client = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return clients;
    }

    public LinkedList<ClientView> SelectAllClientsByFilter(String filterstring)
    {
        String [] strings = filterstring.split(" ");
        String namebyfilter = strings[0];
        String value = strings[1];
        LinkedList<ClientView> clients = new LinkedList<>();

        String select = "SELECT passport.surname, passport.name, passport.middlename, " +
                "client.idClient, client.address, client.email, client.phone " +
                "from client " +
                "join passport on Passport_passportNumber = passportNumber " +
                "WHERE " + namebyfilter + "=" + value;
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                ClientView client = new ClientView();

                client.setIdClient(rs.getInt(Constants.CLIENT_IDCLIENT));
                client.setAddress(rs.getString(Constants.CLIENT_ADDRESS));
                client.setEmail(rs.getString(Constants.CLIENT_EMAIL));
                client.setPhone(rs.getLong(Constants.CLIENT_PHONE));
                client.setName(rs.getString(Constants.PASSPORT_NAME));
                client.setSurname(rs.getString(Constants.PASSPORT_SURNAME));
                client.setMiddlename(rs.getString(Constants.PASSPORT_MIDDLENAME));
                clients.add(client);
                client = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return clients;
    }


    public LinkedList<OrderView> SelectAllOrders()
    {
        LinkedList<OrderView> orders = new LinkedList<>();

        String select = "select motorshow.order.Employee_idEmployee, passport.surname, passport.name, " +
                "car.vin, carbrand.brand, carmodel.model, " +
                "motorshow.order.DateOfSale " +
                "from motorshow.order " +
                "join client on Client_idclient = idClient " +
                "join passport on client.Passport_passportNumber = passportNumber " +
                "join car on Car_VIN = VIN " +
                "join carmodel on CarModel_idCarModel = idCarModel " +
                "join carbrand on CarBrand_idCarBrand = idCarBrand";
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                OrderView order = new OrderView();

                order.setIdEmployee(rs.getInt(Constants.ORDER_IDEMPLOYEE));
                order.setVin(rs.getInt(Constants.CAR_VIN));
                order.setBrand(rs.getString(Constants.CARBRAND_BRAND));
                order.setName(rs.getString(Constants.PASSPORT_NAME));
                order.setSurname(rs.getString(Constants.PASSPORT_SURNAME));
                order.setModel(rs.getString(Constants.CARMODEL_MODEL));
                order.setDateOfSale(rs.getDate(Constants.ORDER_DATEOFSALE).toLocalDate());
                orders.add(order);
                order = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return orders;
    }

    public LinkedList<OrderView> SelectAllOrdersById(String id)
    {
        LinkedList<OrderView> orders = new LinkedList<>();

        String select = "select motorshow.order.Employee_idEmployee, passport.surname, passport.name, " +
                "car.vin, carbrand.brand, carmodel.model, " +
                "motorshow.order.DateOfSale " +
                "from motorshow.order " +
                "join client on Client_idclient = idClient " +
                "join passport on client.Passport_passportNumber = passportNumber " +
                "join car on Car_VIN = VIN " +
                "join carmodel on CarModel_idCarModel = idCarModel " +
                "join carbrand on CarBrand_idCarBrand = idCarBrand "+
                "WHERE Employee_idEmployee = " + id;
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                OrderView order = new OrderView();
                order.setVin(rs.getInt(Constants.CAR_VIN));
                order.setIdEmployee(rs.getInt(Constants.ORDER_IDEMPLOYEE));
                order.setBrand(rs.getString(Constants.CARBRAND_BRAND));
                order.setName(rs.getString(Constants.PASSPORT_NAME));
                order.setSurname(rs.getString(Constants.PASSPORT_SURNAME));
                order.setModel(rs.getString(Constants.CARMODEL_MODEL));
                order.setDateOfSale(rs.getDate(Constants.ORDER_DATEOFSALE).toLocalDate());
                orders.add(order);
                order = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return orders;
    }

    public void ChangeClient(ClientView client)
    {
        String update = "UPDATE client SET address = ?, email = ?, phone = ?  WHERE idClient = ?";

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(update);
            prSt.setString(1, client.getAddress());
            prSt.setString(2, client.getEmail());
            prSt.setString(3, Long.toString(client.getPhone()));
            prSt.setInt(4, client.getIdClient());
            prSt.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void ChangePassportClient(int passportNumber, ClientView clientView)
    {
        String update = "UPDATE passport SET name = ?, surname = ?, middleName = ?, gender = ?, dateOfBirth = ?  WHERE passportNumber = ?";

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(update);
            prSt.setString(1, clientView.getName());
            prSt.setString(2, clientView.getSurname());
            prSt.setString(3, clientView.getMiddlename());
            prSt.setString(4, clientView.getGender());
            prSt.setString(5, clientView.getDateOfBirth().toString());
            prSt.setInt(6, passportNumber);
            prSt.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }


    public int getPaasportNumberInClient(ClientView client1)
    {
        Client client = new Client();

        String select = "SELECT * FROM " + Constants.CLIENT_TABLE + " WHERE " + Constants.CLIENT_IDCLIENT + "=" + client1.getIdClient();
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
                client.setIdClient(rs.getInt(Constants.CLIENT_IDCLIENT));
                client.setAddress(rs.getString(Constants.CLIENT_ADDRESS));
                client.setEmail(rs.getString(Constants.CLIENT_EMAIL));
                client.setPhone(rs.getInt(Constants.CLIENT_PHONE));
                client.setPassportNumber(rs.getInt(Constants.CLIENT_PASSPORTNUMBER));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return client.getPassportNumber();
    }

    public void DeleteOrder(OrderView order)
    {
        String delete = "DELETE FROM  motorshow." + Constants.ORDER_TABLE + " WHERE " + Constants.ORDER_CARVIN +
                " = " + order.getVin();
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void  DeleteClient(ClientView clientView)
    {
        String delete = "DELETE FROM  motorshow." + Constants.CLIENT_TABLE + " WHERE " + Constants.CLIENT_IDCLIENT +
                " = " + clientView.getIdClient();
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteOrderByClient(ClientView clientView)
    {
        String delete = "DELETE FROM  motorshow." + Constants.ORDER_TABLE + " WHERE " + Constants.ORDER_IDCLIENT +
                " = " + clientView.getIdClient();
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeletePassportByClient(int passportNumber)
    {
        String delete = "DELETE FROM  motorshow." + Constants.PASSPORT_TABLE+ " WHERE " + Constants.PASSPORT_PASSPORTNUMBER +
                " = " + passportNumber;
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getCountOrder(String dateAndid)
    {
        int count = 0;
        System.out.println(dateAndid);
        String [] strings = dateAndid.split(" ");
        String date = strings[0];
        String id = strings[1];

        String select = "SELECT COUNT(*) as co FROM motorshow." + Constants.ORDER_TABLE + " WHERE "+Constants.ORDER_IDEMPLOYEE+ "=" + id +" AND DATEDIFF((SELECT CURDATE())," + dm + date + dm+ ") group by Employee_idEmployee ";
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next()) {
              count =  rs.getInt("co");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }

        return count;
    }

    public Employee getEmployeeById(String id)
    {
       Employee employee = new Employee();
        String select = "SELECT * FROM " + Constants.EMPLOYEE_TABLE + " WHERE " + Constants.EMPLOYEE_IDEMPLOYEE + "=" + id;
        ResultSet rs = null;

        try
        {
            PreparedStatement prSt = dbConnection.prepareStatement(select);
            rs = prSt.executeQuery();

            while (rs.next())
            {

                employee.setPosition(rs.getString(Constants.EMPLOYEE_POSITION));
                employee.setIdEmployee(rs.getInt(Constants.EMPLOYEE_IDEMPLOYEE));
                employee.setPassportNumber(rs.getInt(Constants.EMPLOYEE_PASSPORTNUMBER));
                employee.setSalary(rs.getInt(Constants.EMPLOYEE_SALARY));
                employee.setIdUser(rs.getInt(Constants.EMPLOYEE_IDUSER));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return employee;
    }
}
