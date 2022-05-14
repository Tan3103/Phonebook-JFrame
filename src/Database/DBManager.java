package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    public static Connection connection = null;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tannurdb?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
