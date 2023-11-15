/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.RoomDAO;
import java.util.ArrayList;

/**
 *
 * @author huuduc
 */
public class TestConnect {
    public static void main(String[] args) {
        RoomDAO rd = new RoomDAO();
        ArrayList<Room> arr = rd.getAllRoom();
        System.out.println(1);
        if(arr == null){
            System.out.println(-1);
        }
        else{
            for(Room x : arr){
                System.out.println(x);
            }
        }
        
    }
}
