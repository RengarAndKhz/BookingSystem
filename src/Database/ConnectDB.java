package Database;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Tianyang on 3/27/16.
 */
public class ConnectDB {
    final static String DB_URL = "jdbc:mysql://localhost:3306/FlightTest";
    final static String USER_NAME = "root";
    final static String PASSWORD = "";
    final static String DB_DRIVER = "com.mysql.jdbc.Driver";

}
