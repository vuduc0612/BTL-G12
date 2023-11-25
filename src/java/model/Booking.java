/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huuduc
 */
public class Booking {
    private int idBooking;
    private Room room;
    private Customer customer;
    private String checkInDate, checkOutDate;
    private int totalDate;
    public Booking(int id, Room room, Customer customer, String checkInDate, String checkOutDate, int totalDate) {
        this.idBooking = id;
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalDate = totalDate;
    }

    public Room getRoom() {
        return room;
    }
    
    public int getId(){
        return this.idBooking;
    }
    public Customer getCustomer() {
        return customer;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setId(int idBooking) {
        this.idBooking = idBooking;
    }
    
    public void setTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
        try {
            Date date1 = sdf.parse(this.checkInDate);
            Date date2 = sdf.parse(this.checkOutDate);
            long time = (date2.getTime() - date1.getTime())/86400000;
            this.totalDate = (int)time;
        } catch (ParseException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String toString(){
        return this.customer + " " + this.room + " " + this.checkInDate + " " + this.checkOutDate;
    }
}
