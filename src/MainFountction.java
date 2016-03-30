import Database.ControlDB;

import java.beans.PropertyVetoException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianyang on 3/27/16.
 */
public class MainFountction {
    public static void main(String[] args){
        try {
            ControlDB controlDB = new ControlDB();
            ResultSet resultSet = controlDB.getInfo("SELECT * FROM FlightInfo");
            while (resultSet.next()){
                System.out.print(resultSet.getInt("flightID"));
            }
            controlDB.closeDB();


        }
        catch (SQLException e){e.printStackTrace();}
        catch (ClassNotFoundException e){e.printStackTrace();}
        catch (PropertyVetoException e){e.printStackTrace();}
    }
}
