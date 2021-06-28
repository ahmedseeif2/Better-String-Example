/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcountrisandcities;
  
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
/**
 *
 * @author alamia
 */
public class Countries {
    private String code;
    private String countryName;
    private String continent;
    private long population;
    private double surfaceArea;
    private double gnp;
    private int capital;

    public Countries(String code, String countryName, String continent, long population, double surfaceArea, double gnp, int capitalId) {
        this.code = code;
        this.countryName = countryName;
        this.continent = continent;
        this.population = population;
        this.surfaceArea = surfaceArea;
        this.gnp = gnp;
        this.capital = capitalId;
    }
    
    
    

  

    public String getCode() {
        return code;
    }
    public String getCountryName() {
        return countryName;
    }
    public String getContinent() {
        return continent;
    }
    public double getSurfaceArea() {
        return surfaceArea;
    }
    public long getPopulation() {
        return  population;
    }
    public double getGnp() {
        return gnp;
    }
    public int getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return countryName + "[ " + code + " ]";
    }

    

}
