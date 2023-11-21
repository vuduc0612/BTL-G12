/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Booking;
import java.sql.*;

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
            System.out.println(newCheckIn + " " + newCheckOut);
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

    public void insertBooking(int idRoom, int idCustomer, String checkInDate, String checkOutDate) {
        try {
            String sql = "INSERT INTO booking (bookId, customerId, roomId, checkInDate, checkOutDate)\n"
                    + "VALUES (null, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            String arr[] = checkInDate.split("/");
            String newCheckIn = arr[2] + "-" + arr[0] + "-" + arr[1];
            String arr1[] = checkOutDate.split("/");
            String newCheckOut = arr1[2] + "-" + arr1[0] + "-" + arr1[1];
            ps.setInt(1, idCustomer);
            ps.setInt(2, idRoom);
            ps.setString(3, newCheckIn);
            ps.setString(4, newCheckOut);
            int cnt = ps.executeUpdate();
            System.out.println(cnt);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
