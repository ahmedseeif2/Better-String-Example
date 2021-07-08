/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joinerytablesa;

import com.google.common.collect.Table;
import joinery.DataFrame;

import java.io.IOException;
import java.util.List;
import tech.tablesaw.columns.Column;
/**
 *
 * @author alamia
 */
public class MainClass {
    public static void main(String [] args) throws IOException {
        //using joinery to explore the data
        DataFrame <Object> df= DataFrame.readCsv("E:\\AAITI\\OneDrive_1_5-6-2021\\9. Java & UML programming\\Day5\\Data_to_use\\titanic.csv");
        DataFrame<Object> age=df.retain("age");
        DataFrame<Object> fare=df.retain("fare");
        //printing the data table
        System.out.println(df);
        //the age column , max , min , standard deviation
        System.out.println(age);
        System.out.println("age maximum"+age.max()+"\n age minimum"+age.min()+"\n age standard deviation"+age.stddev());
        System.out.println(fare);
        System.out.println("fare maximum"+fare.max()+"\n fare minimum"+fare.min()+"\n fare standard deviation"+fare.stddev());

//Using TableSaw to explore the Data
        com.github.lwhite1.tablesaw.api.Table titanicData;
        String dataPath="src/main/java/titanic.csv";
        titanicData= Table.createFromCsv(dataPath);
        List<Column> dataStructure=titanicData.columns();
        System.out.println(dataStructure);
        //Using Summary to get max,min standard deviation data about each column
        System.out.println(titanicData.summary());


    }
}
