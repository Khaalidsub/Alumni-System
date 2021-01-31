/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Khalid
 */
public class Booking {

    private int id;
    private Date date_start;
    private Date date_end;
    private String time_start;
    private String time_end;
    private int cost;
    private int numberBooking;
    private int userid;

    public Booking(Date date_start, Date date_end, String time_start, String time_end, int cost, int id, int userid) {
        this.date_start = date_start;
        this.date_end = date_end;
        this.time_start = time_start;
        this.time_end = time_end;
        this.cost = cost;
        this.id = id;
        this.userid = userid;
    }

    public Booking() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumberBooking() {
        return numberBooking;
    }

    public void setNumberBooking(int numberBooking) {
        this.numberBooking = numberBooking;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
