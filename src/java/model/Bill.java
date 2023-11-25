/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huuduc
 */
public class Bill {
    private Booking booking;
    private float totalPrice;
    private int billId;

    public Bill(Booking booking, float totalPrice) {
        this.booking = booking;
        this.totalPrice = totalPrice;
    }

    public Booking getBooking() {
        return booking;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public int getBillId() {
        return billId;
    }
    
    public String toString(){
        return this.billId + " " + this.totalPrice + " " + this.billId;
    }
}
