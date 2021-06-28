/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readcountrisandcities;
import static java.util.Collections.max;
import static java.util.Collections.reverseOrder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author alamia
 */
public class MixMappingClass {
    private static HashMap<String, List<Cities>> countryMap = new HashMap<>();

    public static HashMap<String, List<Cities>> getCountryMap() { return countryMap; }

    public static void mappingCountry (List<Cities> cities, List<Countries> countries)
    {
        countries.forEach(country -> {
            List<Cities> cityList = cities.stream()
                    .filter(d -> d.getCountryCode().equals(country.getCode()))
                    .collect(Collectors.toList());

            countryMap.put(country.getCode(), cityList);
        });
    }

    public static void getHighestPopulationCityOfEachCountry()
    {
        countryMap.forEach((Code, value) -> countryMap.get(Code).stream()
                .sorted(Comparator.comparing(Cities::getPopulation).reversed())
                .limit(1)
                .forEach(System.out::println));
    }

    public static void getHighestPopulationCapital(List<Cities> cities, List<Countries> countries)
    {
        List<List<Cities>> capitals = countries.stream().map(country -> cities.stream()
                .filter(d -> country.getCapital() == d.getId())
                .collect(Collectors.toList())).collect(Collectors.toList());

        List<Cities> extractedCapitals = new ArrayList<>();
        capitals.forEach(capital -> {
            try {
                extractedCapitals.add(capital.get(0));
            } catch (Exception exception) { }
        });

        double maxPopulation = extractedCapitals.stream()
                .map(Cities::getPopulation)
                .sorted(reverseOrder())
                .limit(1)
                .toList()
                .get(0);

        System.out.println(extractedCapitals.stream().filter(d -> d.getPopulation() == maxPopulation).toList());
    }
}
