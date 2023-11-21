/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huuduc
 */
public class Customer {
    private String name, sdt, email;
    private int id;

    public Customer(int id, String name, String sdt, String email) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
    
    public String toString(){
        return this.id + " " + this.name + " " + this.email + " " + this.sdt;
    }
}
