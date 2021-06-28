/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcountrisandcities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author alamia
 */
public class CountryDao {
      static List<Countries> countries = new ArrayList<>();

    public static void readCountriesCSV(String path) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        String[] parts;
        Countries country;
        do {
                line = reader.readLine();
                if (line != null)
                {
                    parts = line.split(",");
                    country = new Countries(parts[0], parts[1],
                            parts[2], Integer.parseInt(parts[3]),
                            Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
                            Integer.parseInt(parts[6]));
                    countries.add(country);
                }
            } while (line != null);
        reader.close();
    }

    public static void getCountriesPopulation()
    {
        countries.forEach(d -> System.out.println(d.getCountryName() + " : "+ d.getPopulation()));
    }

    public static double getAveragePopulation()
    {
        return countries.stream().mapToLong(Countries::getPopulation).average().getAsDouble();
    }

    public static long getMaxCountryPopulation()
    {
        return countries.stream().map(Countries::getPopulation).max(Long::compare).get();
    }

    public static List<Countries> getCountryDataset()
    {
        return countries;
    }
}
