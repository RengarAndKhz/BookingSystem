package Search;

import com.sun.javaws.jnl.InformationDesc;
import com.sun.tools.classfile.InnerClasses_attribute;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tianyang on 3/27/16.
 */
public class FlightInfo {
    private int round_oneway = 0; //default oneway
    private int passengerNumber=1; //default one passenger
    private Date departDate;
    private Date backDate;
    private String departure;
    private String arrival;
    private  int first_coach = 0; //default coach



    public void setRound_oneway(int value){
        this.round_oneway = value;
    }
    public int getRoud_oneway(){
        return round_oneway;
    }
    public void setPassengerNumber(int value){
        this.passengerNumber = value;
    }
    public int getPassengerNumber(){
        return passengerNumber;
    }
    public void setDepartDate(Date value){
        this.departDate = value;
    }
    public Date getDepartDate(){
        return departDate;
    }
    public void setBackDate(Date backDate){
        this.backDate = backDate;
    }
    public Date getBackDate(){
        return backDate;
    }
    public void setDeparture(String departure){
        this.departure = departure;
    }
    public String getDeparture(){
        return departure;
    }
    public void setArrival(String arrival){
        this.arrival = arrival;
    }
    public String getArrival(){
        return arrival;
    }
    public void setFirst_coach(int first_coach){
        this.first_coach = first_coach;
    }
    public int getFirst_coach(){
        return first_coach;
    }

}
