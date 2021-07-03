/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xcharttitanic;

import java.io.IOException;
import java.util.List;
/**
 *
 * @author alamia
 */
public class MainClass {
    
    
     public static void main(String[] args) throws IOException{
        
        List<TitanicPassenger1> passengersDataset = new ReadingJsonFile1().getPassengersFromJsonFile();
        
        // the 4 graphing methods
        GraphClass1.graphPassengerAges(passengersDataset);
        GraphClass1.graphPassengerClass(passengersDataset);
        GraphClass1.graphPassengerSurvived(passengersDataset);
        GraphClass1.graphPassengerSurvivedGender(passengersDataset);
    }
}
