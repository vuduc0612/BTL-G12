/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Bill;
import java.sql.*;
/**
 *
 * @author huuduc
 */
public class BillDAO extends DAO{

    public BillDAO() {
        super();
    }
    
    public void insertBill(Bill bill){
        String sql = "insert into bill values(null, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bill.getBooking().getId());
            ps.setFloat(2, bill.getTotalPrice());
            int cnt = ps.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
