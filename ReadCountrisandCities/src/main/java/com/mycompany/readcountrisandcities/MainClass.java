/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcountrisandcities;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author alamia
 */
public class MainClass {
     public static void main(String[] args) throws IOException
    {
        CountryDao.readCountriesCSV("E:\\AAITI\\OneDrive_1_5-6-2021\\9. Java & UML programming\\Day4\\Data_sets\\Countries.csv");
        CityDao.readCitiesCSV("E:\\AAITI\\OneDrive_1_5-6-2021\\9. Java & UML programming\\Day4\\Data_sets\\Cities.csv");

        System.out.println("\n A List Of Countries Population: ");
        CountryDao.getCountriesPopulation();

        System.out.println("\n Average Population is : " + CountryDao.getAveragePopulation());
        System.out.println("\n Maximum Population is : " + CountryDao.getMaxCountryPopulation());

        MixMappingClass.mappingCountry(CityDao.getCityDataset() ,CountryDao.getCountryDataset());
        System.out.println("\n Highest Population City of each Country: ");
        MixMappingClass.getHighestPopulationCityOfEachCountry();

        System.out.println("\n Highest Population Capital");
        MixMappingClass.getHighestPopulationCapital(CityDao.getCityDataset() ,CountryDao.getCountryDataset());

    }
}
