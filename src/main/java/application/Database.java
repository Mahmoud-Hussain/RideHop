package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public Connection databaseLink;

    public Connection getConnection() {

        String databaseuser = "root";
        String databasepassword = "root123";
        String url = "jdbc:mysql://localhost:3306/car";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseuser, databasepassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;


    }
}
