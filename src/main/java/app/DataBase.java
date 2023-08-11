//package app;
//import java.sql.*;
//
//public class DataBase {
//
//    public Connection databaseLink;
//    public Connection getConnection(){
//
//       String databaseuser = "root";
//       String databasepassword ="root123";
//       String url = "jdbc:mysql://localhost:3306/dat-base";
//
//       try{
//           Class.forName("com.mysql.cj.jdbc.Driver");
//           databaseLink = DriverManager.getConnection(url,databaseuser,databasepassword);
//       }
//
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return  databaseLink;
//
//    }
//
//
//}
