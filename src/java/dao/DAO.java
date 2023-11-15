/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author huuduc
 */
public class DAO {
    protected static Connection con;
    
    public DAO(){
        String url = "jdbc:mysql://localhost:3306/hotel?autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "Huuduc1234";
        if(con == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, username,password);
            } catch(Exception ex){
                ex.printStackTrace();
            }
        } 
    }
}
