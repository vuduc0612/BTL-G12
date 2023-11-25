/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Booking;
import java.sql.*;
import java.util.ArrayList;
import model.Customer;
import model.Room;

/**
 *
 * @author huuduc
 */
public class BookingDAO extends DAO {

    public BookingDAO() {
        super();
    }

    public boolean check(String checkInDate, String checkOutDate, int idRoom) {
        try {
            String sql = "SELECT *\n"
                    + "FROM booking\n"
                    + "WHERE roomId = ?\n"
                    + "AND (\n"
                    + "    (checkInDate >= ? AND checkInDate < ?)\n"
                    + "    OR (checkOutDate > ? AND checkOutDate <= ?)\n"
                    + "    OR (checkInDate <= ? AND checkOutDate >= ?)\n"
                    + ");";

            String arr[] = checkInDate.split("/");
            String newCheckIn = arr[2] + "-" + arr[0] + "-" + arr[1];
            String arr1[] = checkOutDate.split("/");
            String newCheckOut = arr1[2] + "-" + arr1[0] + "-" + arr1[1];
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRoom);
            ps.setString(2, newCheckIn);
            ps.setString(3, newCheckOut);
            ps.setString(4, newCheckIn);
            ps.setString(5, newCheckOut);
            ps.setString(6, newCheckIn);
            ps.setString(7, newCheckOut);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public int insertBooking(int idRoom, int idCustomer, String checkInDate, String checkOutDate, int totalDate) {
        try {
            String sql = "INSERT INTO booking\n"
                    + "VALUES (null, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            String arr[] = checkInDate.split("/");
            String newCheckIn = arr[2] + "-" + arr[0] + "-" + arr[1];
            String arr1[] = checkOutDate.split("/");
            String newCheckOut = arr1[2] + "-" + arr1[0] + "-" + arr1[1];
            ps.setInt(1, idCustomer);
            ps.setInt(2, idRoom);
            ps.setString(3, newCheckIn);
            ps.setString(4, newCheckOut);
            ps.setInt(5, totalDate);
            int cnt = ps.executeUpdate();
            if (cnt > 0) {
                int idBk;
                sql = "SELECT LAST_INSERT_ID()";
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    idBk = rs.getInt(1);
                    return idBk;
                }
            }
            return -1;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public ArrayList<String> getBookedDate(int roomId) {
        try {
            ArrayList<String> arr = new ArrayList();
            String sql = "select * from booking\n"
                    + "where booking.roomId = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roomId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String a1[] = rs.getString("checkInDate").split("-");
                String newCheckIn = a1[1] + "/" + a1[2] + "/" + a1[0];
                String a2[] = rs.getString("checkOutDate").split("-");
                String newCheckOut = a2[1] + "/" + a2[2] + "/" + a2[0];
                arr.add(newCheckIn + " " + newCheckOut);
            }
            return arr;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
