package com.mycompany.spktest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class YoutubeTitleWordCount {
    private static final String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws IOException {
        Logger.getLogger ("org").setLevel (Level.ERROR);
        // CREATE SPARK CONTEXT
        SparkConf conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);
        // LOAD DATASETS
        JavaRDD<String> videos = sparkContext.textFile ("E:\\AAITI\\OneDrive_1_5-6-2021\\9. Java & UML programming\\Day6\\USvideos.csv");
        
        System.out.println (" Popular Titles ");
        popularTitle(videos);
        System.out.println (" Popular Tags ");
        popularTags(videos);
   
        

    }
    public static String extractTitle(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
        
    }
    public static String extractTags(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
        
    }
     public static void popularTitle(JavaRDD<String> videos) {
        // TRANSFORMATIONS
        JavaRDD<String> titles = videos
                .map (YoutubeTitleWordCount::extractTitle)
                .filter (StringUtils::isNotBlank);
        // COUNTING
        Map<String, Long> wordCounts = titles.countByValue ();
        List<Map.Entry> sorted = wordCounts.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList());
        Collections.reverse(sorted);
        // DISPLAY
        for (Map.Entry<String, Long> entry : sorted) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        }
    }
    
    public static void popularTags(JavaRDD<String> videos) {
        // TRANSFORMATIONS
        JavaRDD<String> tags = videos
                .map (YoutubeTitleWordCount::extractTags)
                .flatMap (tag -> Arrays.asList (tag
                .toLowerCase ()
                .split ("\\|")).iterator ())
                .filter (StringUtils::isNotBlank);
        // COUNTING
        Map<String, Long> wordCounts = tags.countByValue ();
        List<Map.Entry> sorted = wordCounts.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList());
        Collections.reverse(sorted);
        // DISPLAY
        for (Map.Entry<String, Long> entry : sorted) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        }
    }
    
}
