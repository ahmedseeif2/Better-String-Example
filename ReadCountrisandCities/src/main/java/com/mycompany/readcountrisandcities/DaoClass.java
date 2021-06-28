/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcountrisandcities;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
/**
 *
 * @author alamia
 */
public class DaoClass {
    public List<Countries> readCountriesFromCSV(String fileName){
        List<Countries> country = new ArrayList<>();
        try{
        Reader r = new FileReader(fileName);
        BufferedReader br = new BufferedReader(r);
        String line = br.readLine();
        
        do{
            line = br.readLine();
            if(line != null){
                String[] attributes = line.split(",");
                Countries c = createCountry(attributes);
                country.add(c);
            }
        }while(line != null);
        
        }catch (IOException ex){
                    ex.printStackTrace();
        }
        return country;
    }
    
    public Countries createCountry(String[] metadata){
        String code = metadata[0];
        String name = metadata[1];
        String continent = metadata[2];
        String surfaceArea = metadata[3];
        String gnp = metadata[4];
        String capital = metadata[5];
        //create and return pyramid of this metadata
        Countries cr = new Countries( code , name , continent, surfaceArea , gnp, capital  );
     
        return cr;
            
    }
    
    public List<Cities> readCitiesFromCSV(String fileName){
        List<Cities> city = new ArrayList<>();
        try{
        Reader r = new FileReader(fileName);
        BufferedReader br = new BufferedReader(r);
        String line = br.readLine();
        
        do{
            line = br.readLine();
            if(line != null){
                String[] attributes = line.split(",");
                Cities ci = createCity(attributes);
                city.add(ci);
            }
        }while(line != null);
        
        }catch (IOException ex){
                    ex.printStackTrace();
        }
        return city;
    }
    
    public Cities createCity(String[] metadata){
        String id = metadata[0];
        String name = metadata[1];
        String population = metadata[2];
        String countrycode = metadata[3];
        //create and return pyramid of this metadata
        Cities ci = new Cities( id , name , population, countrycode );
     
        return ci;
            
    }
    
//    public Map<String, String> mapCountryCities(String fileName1 , String fileName2) throws IOException{
//       // Map<String, String> countryCities = new HashMap<String, String>();
//        Countries cr = new Countries();
//        Cities ci = new Cities();
//        String name = ci.getName();
//        String code = cr.getCode();
//        // = new ArrayList<>();
//        List<Cities> resultMap =  lines.map(code,name).collect(toList);
//        Stream<String> lines = Files.lines(Paths.get(fileName1, fileName2));
//        Map<String, String> resultMap;
//        resultMap = lines.map(code , name).collect(toList);
//
//        lines.close();
//
//        return resultMap
//    
//    }
    
    
//    public Map<String, List<Cities>> mapCountryCities(String fileName1 , String fileName2) throws IOException{
//   //      Map<String, List<Cities>> countryCities = new HashMap<String, List<Cities>>();
//         Countries cr = new Countries();
//         List<Cities> city = new ArrayList<>();
//         String code = cr.getCode();
//         //Stream<String> lines = Files.lines(Paths.get(fileName1 , fileName2));
//         //Stream<String> lines = Stream.of(fileName1, fileName2);   //Paths.get(fileName1 , fileName2));
//         Map<String, List<Cities>> resultMap =  city.stream().map(code,city).collect(toList);
////                lines.map(line -> line.split(","))
////                     .collect(Collectors.toMap(line -> line[0], line -> line[1]));
////
////        lines.close();
//         
//         return resultMap;
//         
//    }
//    public class sortingByHight implements Comparator<Pyramids> {
//
//        @Override
//        public int compare(Pyramids a , Pyramids b) {
//            Double h1 = a.getHeight();
//            Double h2 = b.getHeight();
//            int diff = h1.compareTo(h2);
//            return diff;
//            
//        }
//  
//        
//    }

    
}
