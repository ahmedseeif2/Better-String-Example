/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xcharttitanic;



import java.awt.Color;
import java.util.*;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

/**
 *
 * @author alamia
 */
public class GraphClass1 {
    
    public static void graphPassengerAges(List<TitanicPassenger1> passengerList) {
        
        //filter to get an array of passenger ages
        List<Float> pAges = passengerList.stream().map(TitanicPassenger1::getAge).limit(8).collect(Collectors.toList());
        List<String> pNames = passengerList.stream().map(TitanicPassenger1::getName).limit(8).collect(Collectors.toList());
        
        //Using XCart to graph the Ages 
        // 1.Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build();
        
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        
        // 3.Series
        chart.addSeries("Passenger's Ages", pNames, pAges);
        
        // 4.Show it
        new SwingWrapper(chart).displayChart();
}
    
    public static void graphPassengerClass(List<TitanicPassenger1> passengerList) {
        
        //filter to get a map of passenger class and total number of passengers in each class
        Map<String, Long> result = passengerList.stream().collect(Collectors.groupingBy(TitanicPassenger1::getPclass, Collectors.counting()));
        
        // Create Chart
//        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build ();
        PieChart chart = new PieChartBuilder().width(800).height(600).build();

        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler().setSeriesColors (sliceColors);
        
        // Series
        chart.addSeries("First Class", result.get("1"));
        chart.addSeries("Second Class", result.get("2"));
        chart.addSeries("Third Class", result.get("3"));
        
        // Show it
        new SwingWrapper(chart).displayChart();
}
    
    public static void graphPassengerSurvived(List<TitanicPassenger1> passengerList) {
        
        
        Map<String, Long> result = passengerList.stream().collect(Collectors.groupingBy(TitanicPassenger1::getSurvived, Collectors.counting()));
        
        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).build();
        
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler().setSeriesColors (sliceColors);
        
        // Series
        chart.addSeries("Not Survived", result.get("0"));
        chart.addSeries("Survived", result.get("1"));
        
        // Show it
        new SwingWrapper(chart).displayChart();
    }
    
    public static void graphPassengerSurvivedGender(List<TitanicPassenger1> passengerList) {
        
        Map<String, Long> result = passengerList.stream()
                                                .filter(p -> p.getSurvived().equals("1"))
                                                .collect(Collectors.groupingBy(TitanicPassenger1::getSex, Collectors.counting()));

        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).build();
        
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler().setSeriesColors (sliceColors);
        
        // Series
        chart.addSeries ("Female Survived", result.get ("female"));
        chart.addSeries ("Male Survived", result.get ("male"));
        
        // Show it
        new SwingWrapper(chart).displayChart();
    }
    
}
