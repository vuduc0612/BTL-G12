/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author huuduc
 */
public class Room {
    private int id, guest, rate, square;
    private String name, type, des;
    private float price, sale;
    private ArrayList<String> img;

    public Room(int id, String name, String type, float price, 
            float sale, ArrayList<String> img, int guest, int rate, int square, String des) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.sale = sale;
        this.img = img;
        this.guest = guest;
        this.rate = rate;
        this.square = square;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        String res = "";
        String ans = "" + (int)this.price;
        int idx = 1;
        for(int i = ans.length() - 1; i >= 0; i--){
            res = ans.charAt(i) + res;
            if(idx % 3 == 0 && idx != 0 && i != 0) res = "." + res;
            idx += 1;
        }
        return res;
    }
    
    public float getGia(){
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public String getImg() {
        return img.get(0);
    }

    public void setImg(ArrayList<String> img) {
        this.img = img;
    }

    public int getGuest() {
        return guest;
    }

    public int getRate() {
        return rate;
    }

    public int getSquare() {
        return square;
    }

    public String getDes() {
        return des;
    }
    
    public String toString(){
        return this.id + " " + this.name + " " + this.type + " " + this.getPrice() + " " + this.sale;
    }
}
