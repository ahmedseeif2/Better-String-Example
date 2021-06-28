/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcountrisandcities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author alamia
 */
public class CityDao {
    private static final List<Cities> cities = new ArrayList<>();

    public static void readCitiesCSV(String path) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        String[] metadata;
        Cities city;

        do {
            line = reader.readLine();
            if (line != null)
            {
                metadata = line.split(",");
                city = new Cities(Integer.parseInt(metadata[0]),
                        metadata[1],
                        Integer.parseInt(metadata[2]),
                        metadata[3]);
                cities.add(city);
            }
        } while (line != null);
        reader.close();
    }

    public static void getCitesOfCountry(String Code)
    {
        cities.stream().filter(d -> d.getCountryCode().equals(Code)).forEach(System.out::println);
    }

    public static void getAllCitiesPopulation (String Code)
    {
        cities.stream()
                .filter(d -> d.getCountryCode().equals(Code))
                .map(Cities::getPopulation)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }


    public static List<Cities> getCityDataset()
    {
        return cities;
    }
}
