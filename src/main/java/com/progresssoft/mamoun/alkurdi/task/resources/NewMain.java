/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.progresssoft.mamoun.alkurdi.task.resources;

import com.ProgresssSoft.Data.FXdealsResquest;
import com.progresssoft.DataBase.DataBaseConfigration;
import com.progresssoft.DataBase.DataBaseFunctions;

/**
 *
 * @author Mamoun-Alkurdi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    DataBaseConfigration baseConfigration = new DataBaseConfigration();
    
    DataBaseFunctions df = new DataBaseFunctions();
    FXdealsResquest fXdealsResquest = new FXdealsResquest();
    
    fXdealsResquest.setDealAmount("11");
     fXdealsResquest.setDealId("11");
      fXdealsResquest.setFromCurrency("11");
       fXdealsResquest.setTimestamp("11");
        fXdealsResquest.setToCurrency("11"); 
        
    df.acceptdeals(fXdealsResquest);

    df.checkCurrancy("JOR", "EGP");
    }
    
}
