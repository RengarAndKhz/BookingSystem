package Search;

import Database.ControlDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tianyang on 3/27/16.
 */
public class SearchImp {
    //List<InfoFromUser>
    private int round_oneway = 0;
    private int passengerNumber = 1;
    private Date departDate;
    private Date backDate;
    private String departure;
    private String arrival;
    private  int first_coach = 0;
    private ControlDB controlDB;
    public SearchImp(FlightInfo inputInfoFromUser, ControlDB controlDB){
        this.controlDB = controlDB;
        round_oneway = inputInfoFromUser.getRoud_oneway();
        passengerNumber = inputInfoFromUser.getPassengerNumber();
        departDate = inputInfoFromUser.getDepartDate();
        if (departDate == null){
            throw new IllegalArgumentException("departDate is not valid");
        }
        backDate = inputInfoFromUser.getBackDate();
        if (backDate == null){
            throw new IllegalArgumentException("backDate is not valid");
        }
        departure = inputInfoFromUser.getDeparture();
        if (departure == null){
            throw new IllegalArgumentException("departure is not valid");
        }
        arrival = inputInfoFromUser.getArrival();
        if (arrival == null){
            throw new IllegalArgumentException("arrival is not valid");
        }
        this.first_coach = inputInfoFromUser.getFirst_coach();
    }
    public List<InfoFromDB> getFlightInfoList(FlightInfo flightInfo) throws SQLException{
        //int coach_first = flightInfo.getFirst_coach();
        String seatClass = "coachSeat";
        if (first_coach == 1){
            seatClass = "firstSeat";
        }

        List<InfoFromDB> resultList = new ArrayList<>();
        ResultSet info = controlDB.getInfo("SELECT * FROM FlightInfo WHERE depature =" + flightInfo.getDeparture() +
                ", arrival =" + flightInfo.getArrival() + "departDate =" + flightInfo.getDepartDate() + ";"
        );
        while (info.next()){
            InfoFromDB tempInstance = new InfoFromDB();
            int planeID = info.getInt("planeID");
            ResultSet planeInfo = controlDB.getInfo("SELECT" + seatClass + "FROM PlaneInfo WHERE planeID =" + planeID + ";");
            int seatCapacity = planeInfo.getInt(seatClass);
            int seatLeft = seatCapacity - info.getInt(seatClass.substring(0, 6) + "Passenger");
            tempInstance.setDeparture(info.getString("departure"));
            tempInstance.setDepartDate(info.getDate("departDate"));
            tempInstance.setDepartTime(info.getTime("departTime"));
            tempInstance.setArrival(info.getString("arrival"));
            tempInstance.setArriveDate(info.getDate("arriveDate"));
            tempInstance.setArriveTime(info.getTime("arriveTime"));
            tempInstance.setPrice(info.getDouble("price"));
            tempInstance.setSeatLeft(seatLeft);
            resultList.add(tempInstance);
        }
        return resultList;

    }

    public List<FlightInfo> getConnectionFlight(){}

}
