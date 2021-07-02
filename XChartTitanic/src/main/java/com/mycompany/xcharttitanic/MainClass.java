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
        
        List<TitanicPassenger> passengersDataset = new ReadingJsonFile().getPassengersFromJsonFile();
        
        // the 4 graphing methods
        GraphClass.graphPassengerAges(passengersDataset);
        GraphClass.graphPassengerClass(passengersDataset);
        GraphClass.graphPassengerSurvived(passengersDataset);
        GraphClass.graphPassengerSurvivedGender(passengersDataset);
    }
}
