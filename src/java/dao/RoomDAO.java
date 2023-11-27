/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import model.Room;

/**
 *
 * @author huuduc
 */
public class RoomDAO extends DAO {

    public RoomDAO() {
        super();
    }

    public ArrayList<Room> getAllRoom() {
        String sql = "select rooms.*, roomimages.imgURL\n"
                + "from rooms\n"
                + "inner join roomImages on rooms.roomId = roomImages.roomId;";
        try {
            int cnt[] = new int[10];
            ArrayList<Room> arr = new ArrayList();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ArrayList<String> img = new ArrayList();
                img.add(rs.getString("imgURL"));
                if(cnt[rs.getInt("roomId")] == 0){
                    arr.add(new Room(rs.getInt("roomId"), rs.getString("roomName"),
                        rs.getString("roomType"), rs.getFloat("price"),
                        rs.getFloat("sale"), img, rs.getInt("guest"),
                        rs.getInt("rate"), rs.getInt("square"),
                        rs.getString("description"), rs.getString("detail")));
                    cnt[rs.getInt("roomId")] += 1;
                }
            }
            return arr;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Room getRoom(String type) {
        String sql = String.format("select rooms.*, roomimages.imgURL\n"
                    + "from rooms\n"
                    + "inner join roomImages on rooms.roomId = roomImages.roomId\n"
                    + "where roomType = \"%s\";", type);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ArrayList<String> img = new ArrayList();
                img.add(rs.getString("imgURL"));

                return new Room(rs.getInt("roomId"), rs.getString("roomName"),
                        rs.getString("roomType"), rs.getFloat("price"),
                        rs.getFloat("sale"), img, rs.getInt("guest"),
                        rs.getInt("rate"), rs.getInt("square"),
                        rs.getString("description"), rs.getString("detail"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
