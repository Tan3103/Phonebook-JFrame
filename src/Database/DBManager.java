package Database;
import Class.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    public static Connection connection = null;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/newdatabase?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO user (id, name, surname, login, password) " +
                    "VALUES (NULL, ?, ?, ?, ?)");

            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addPhone(PhoneNumbers phoneNumbers, User user) {
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO phone (id, user_id, name, surname, type, phonenumber) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?)");

            statement.setInt(1, user.getId());
            statement.setString(2, phoneNumbers.getName());
            statement.setString(3, phoneNumbers.getSurname());
            statement.setString(4, phoneNumbers.getType());
            statement.setString(5, phoneNumbers.getPhoneNumber());

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public User getUser(String log){
        User user = new User();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE login = '" + log + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                user = new User(id, login, password, name, surname);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public void deletePhone(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "DELETE FROM phone WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<PhoneNumbers> getMyPhone(User user){
        ArrayList<PhoneNumbers> phoneList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM phone WHERE user_id = '" + user.getId() + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phoneNumber = resultSet.getString("phonenumber");
                String type = resultSet.getString("type");

                phoneList.add(new PhoneNumbers(id,  name, surname, type, phoneNumber));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return phoneList;
    }

    public ArrayList<PhoneNumbers> getAllPhone(User user){
        ArrayList<PhoneNumbers> phoneList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM phone ");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phoneNumber = resultSet.getString("phonenumber");
                String type = resultSet.getString("type");

                phoneList.add(new PhoneNumbers(id,  name, surname, type, phoneNumber));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return phoneList;
    }

    public ArrayList<PhoneNumbers> findName(String findName){
        ArrayList<PhoneNumbers> phoneList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM phone WHERE name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String type = resultSet.getString("type");
                String phoneNumber = resultSet.getString("phonenumber");

                phoneList.add(new PhoneNumbers(id,  name, surname, type, phoneNumber));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return phoneList;
    }

    public ArrayList<PhoneNumbers> findPhone(String findPhone){
        ArrayList<PhoneNumbers> phoneList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM phone WHERE phonenumber = '" + findPhone + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String type = resultSet.getString("type");
                String phoneNumber = resultSet.getString("phonenumber");

                phoneList.add(new PhoneNumbers(id,  name, surname, type, phoneNumber));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return phoneList;
    }
}
