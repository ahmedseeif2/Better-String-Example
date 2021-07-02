/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xcharttitanic;
package xchartPkg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author alamia
 */
public class ReadingJsonFile {
    
    
    // Read json file and return a list containing TitanicPassenger Objects
        public List<TitanicPassenger> getPassengersFromJsonFile() throws FileNotFoundException, IOException {
            
            List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger> ();
            
            ObjectMapper objectMapper = new ObjectMapper ();
            objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            
            InputStream input = new FileInputStream ("C:\\Users\\SaiF El-deen\\Desktop\\JavaITI\\Data_to_use\\titanic_csv.json");
            //Read JSON file
            allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>(){});
            return allPassengers;
}
}
