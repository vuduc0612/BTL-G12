/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.xdevapi.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customer;

/**
 *
 * @author huuduc
 */
public class CustomerDAO extends DAO{

    public CustomerDAO() {
    }
    
    public Customer insertCus(String name, String email, String tel){
        try{
            String sql = "insert into customers values" +
                        "(null, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, tel);
            int cnt = ps.executeUpdate();
            if(cnt > 0){
                int idCus;
                sql = "SELECT LAST_INSERT_ID()";
                ResultSet rs = ps.executeQuery(sql);
                if(rs.next()){
                    idCus = rs.getInt(1);
                    sql = "select * from customers where customerId = ?";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, idCus);
                    ResultSet rst = ps.executeQuery();
                    if(rst.next())
                        return new Customer(rst.getInt("customerId"), rst.getString("customerName"),
                         rst.getString("email"),rst.getString("tel"));
                }
//                        
            }
            return null;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
