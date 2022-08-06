/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progresssoft.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mamoun-Alkurdi
 */
public class DataBaseConfigration {
//     public Connection dbcon1;

     public Connection getConnection() {
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            
              Connection conn = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/forex_exchange?autoReconnect=true&useSSL=false"
                      , "root","P@ssw0rd");

            System.out.println("Connection success");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection refuse" + e);
        }
         return null;
        
    }

}
