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
        super();
    }
    
    public int insertCus(Customer cus){
        try{
            String sql = "insert into customers values" +
                        "(null, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getEmail());
            ps.setString(3, cus.getSdt());
            int cnt = ps.executeUpdate();
            if(cnt > 0){
                int idCus;
                sql = "SELECT LAST_INSERT_ID()";
                ResultSet rs = ps.executeQuery(sql);
                if(rs.next()){
                    idCus = rs.getInt(1);
                    return idCus;
                }                       
            }
            return -1;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }
    
}
