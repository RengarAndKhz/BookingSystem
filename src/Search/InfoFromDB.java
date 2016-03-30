package Search;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Tianyang on 3/30/16.
 */
public class InfoFromDB {
    private String departure;
    private Date departDate;
    private Time departTime;
    private String arrival;
    private Date arriveDate;
    private Time arriveTime;
    private double price;
    private int seatLeft;

    public void setDeparture(String departure){
        this.departure = departure;
    }
    public String getDeparture(){
            return departure;
    }
    public void setDepartDate(Date departDate){
        this.departDate = departDate;
    }
    public Date getDepartDate(){
        return departDate;
    }
    public void setDepartTime(Time departTime){
        this.departTime = departTime;
    }
    public Time getDepartTime(){
        return departTime;
    }
    public void setArrival(String arrival){
        this.arrival = arrival;
    }
    public String getArrival(){
        return arrival;
    }
    public void setArriveDate(Date arriveDate){
        this.arriveDate = arriveDate;
    }
    public Date getArriveDate(){
        return arriveDate;
    }
    public void setArriveTime(Time arriveTime){
        this.arriveTime = arriveTime;
    }
    public Time getArriveTime(){
        return arriveTime;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public void setSeatLeft(int seatLeft){
        this.seatLeft = seatLeft;
    }
    public int getSeatLeft(){
        return seatLeft;
    }
}
