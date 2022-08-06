/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progresssoft.DataBase;

import com.ProgresssSoft.Data.FXdealsResquest;
import com.progresssoft.mamoun.alkurdi.task.resources.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 *
 * @author Mamoun-Alkurdi
 */
public class DataBaseFunctions {
 static final Logger log1 = Logger.getLogger(Service.class);
    Connection con;
    DataBaseConfigration db;

    public DataBaseFunctions() throws Exception {
        db = new DataBaseConfigration();
        con = db.getConnection();
    }
//    

    public String acceptdeals(FXdealsResquest fXdealsResquest1) throws SQLException {

        try {
            String query = "INSERT INTO `forex_exchange`.`fx-deals` (`idfx-deals`, `FromCurrency`, `ToCurrency`, `DealTimestamp`, `DealAmount`) VALUES ('" + fXdealsResquest1.getDealId() + "', '" + fXdealsResquest1.getFromCurrency() + "', '" + fXdealsResquest1.getToCurrency() + "', '" + fXdealsResquest1.getTimestamp() + "', '" + fXdealsResquest1.getDealAmount() +"')";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.execute();

            con.close();
            return "Successful";
        } catch (SQLException ex) {
         log1.error("Error :" ,ex);
            System.out.println(ex);
            String error = ex + "";
            String exception = error.substring(0, 66);
            System.out.println(exception);
            return exception;

        }

    }

//PreparedStatement stmt;
//        try {
//            stmt = con.prepareStatement("insert into fx-deals values (  ? ,  ? ,?, ? ,?)");
//            stmt.setString(1, "1166");
//            stmt.setString(2, "22");
//            stmt.setString(3, "33");
//            stmt.setString(4, "44");
//            stmt.setString(5, "55");
//            stmt.executeUpdate();
//    
//        } catch (SQLException ex) {
////            Logger.getLogger(DatabaseFunction.class.getName()).log(Level.SEVERE, null, ex);
//            con.close();
//            return "";
//            
//        }
//                con.close();
//        return "";
//    }
//    
    public String checkCurrancy(String fromcurrancy, String tocurrancy) throws SQLException {
        try {
            Statement sta1;
            ResultSet rs = null;
            sta1 = con.createStatement();
            String sql = "SELECT count(*) FROM forex_exchange.currency where fromCurrencyIsoCode = '" + fromcurrancy + "' or fromCurrencyIsoCode = '" + tocurrancy + "' ";
            rs = sta1.executeQuery(sql);

           
            while (rs.next()) {
                
                String x = rs.getString("count(*)");                
                if(x.equals("2")){
                
                return "success";
                
              
                }
                else{
                           return "Invalid currency codes";
                
                }

            }
//else {

                return "Invalid currency codes";
//            }

        } catch (Exception ex) {
            log1.error("Error :" ,ex);
            return "internal error";
        }
       
//        return "";

    }

}
