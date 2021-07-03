/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xcharttitanic;
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
public class ReadingJsonFile1 {
    
    
    // Read json file and return a list containing TitanicPassenger1 Objects
        public List<TitanicPassenger1> getPassengersFromJsonFile() throws FileNotFoundException, IOException {
            
            List<TitanicPassenger1> allPassengers = new ArrayList<TitanicPassenger1> ();
            
            ObjectMapper objectMapper = new ObjectMapper ();
            objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            
            InputStream input = new FileInputStream ("E:\\AAITI\\OneDrive_1_5-6-2021\\9. Java & UML programming\\Day5\\Data_to_use\\titanic.csv");
            //Read JSON file
            allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger1>>(){});
            return allPassengers;
}
}
