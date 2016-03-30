package Database;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import static Database.ConnectDB.*;

/**
 * Created by Tianyang on 3/27/16.
 */
public class ControlDB {
    private Connection connection = null;
    private ComboPooledDataSource cpds = null;
    //private static ControlDB singleton = null;

    public ControlDB() throws ClassNotFoundException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass(DB_DRIVER);
        cpds.setJdbcUrl(DB_URL);
        cpds.setUser(USER_NAME);
        cpds.setPassword(PASSWORD);
        connection = cpds.getConnection();
        /*if (connection != null){
            return;
        }
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);*/
    }

    /**
     * singleton instance
     * @return a new instance of class ControlDB
     * @throws ClassNotFoundException
     * @throws SQLException
     *
    public static ControlDB getSingleton() throws ClassNotFoundException, SQLException{
        if (singleton != null){
            return singleton;
        }
        singleton = new ControlDB();
        return singleton;
    }*/


    public ResultSet getInfo(String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        return resultSet;
    }


    public void closeDB() throws SQLException{
        //cpds.close();
        connection.close();

    }


    public void updataDB(String sqlQuery) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

    }

    public List<String> getPlaces() throws SQLException{
        List<String> result = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM PlaceInfo");
        while (resultSet.next()){
            result.add(resultSet.getString("name"));
        }
        return result;
    }
    /*public static void main(String[] args){

        try {
            ControlDB testCase = new ControlDB();
        }catch (Exception e){e.printStackTrace();}
    }*/
}
