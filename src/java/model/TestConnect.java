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
        String name = "Standard";
        String sql = String.format("select rooms.*, roomimages.imgURL\n"
                    + "inner join roomImages on rooms.roomId = roomImages.roomId\n"
                    + "where roomType = \"%s\";", name);
        System.out.println(sql);
    }
}
