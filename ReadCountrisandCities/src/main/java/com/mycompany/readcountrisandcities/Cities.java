/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcountrisandcities;

/**
 *
 * @author alamia
 */
public class Cities {
    private int id;
    private String name;
    private int population;
    private String countryCode;

    public Cities (int id, String name, int cityPobulation, String countryCode)
    {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }

    public int getId() {
       return id;
    }
    public String getName() {
       return name;
    }
    public int getPopulation() {
       return population;
    }
    public String getCountryCode() {
       return countryCode;
    }

    @Override
    public String toString()
    {
        return "City [" + name + ", population:" + population + " " + countryCode + "]";
    }

}
