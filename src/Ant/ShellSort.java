/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JuthamasS
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

// Java implementation of recursive Binary Search
public class ShellSort {

    private Map<String, Double> data;

    public static void display(Map<String, Double> data) {
        System.out.println("Data:");
        for (String key : data.keySet()) {
            System.out.print(key + " " + data.get(key) + " ");
            System.out.println("");
        }
    }

    public static void display2(Map<String, Map<String, Double>> data) {
        System.out.println("Data:");
        for (String key : data.keySet()) {
            System.out.print(key + " " + data.get(key) + " ");
            System.out.println("");
        }
    }

    public void shellSort(Map<String, Double> data) {
        Map<String, Map<String, Double>> sortData = new TreeMap<>();
        Map<String, Double> data2 = new TreeMap<>();
        data2.putAll(data);
        int len = data.size();  //10
        ArrayList<String> a = new ArrayList<>();
        String[] b = new String[len];  //10
        int index = 0;

        
    }public void sort(int[] numbers) { 
        
        if (numbers == null || numbers.length == 0) { 
            return; } 
        this.input = numbers; 
        length = numbers.length; 
        quickSort(0, length - 1); 
    } 


    public void sort(int low,int high,Map<String, Double> data){
        int i= low;
        int j = high;
        int pivot = (low + (high-low)/2);
        
        while(i<=j){
            while(input){
                
            }
        }
    }
    public static void main(String[] args) {
        int maxSize = 10;
        ShellSort shell = new ShellSort();
        Map<String, Double> map = new TreeMap();
        map.put("ch1", 90.3);
        map.put("ch2", 1.9);
        map.put("ch3", 9.3);
        map.put("ch4", 7.3);
        map.put("ch5", 1.0);
        map.put("ch6", 10.9);
        map.put("ch7", 75.3);
        map.put("ch8", 1.9);
        map.put("ch9", 10.3);
        map.put("ch10", 90.4);
        /*  map.put("ch11", 1.8);
        map.put("ch12", 11.3);
        map.put("ch13", 100.3);
        map.put("ch14", 12.3);
        map.put("ch15", 55.8);
        map.put("ch16", 102.3);
        map.put("ch17", 90.3);
        map.put("ch18", 1.8);
        map.put("ch19", 11.3);
        map.put("ch20", 100.3);
        map.put("ch21", 12.3);
        map.put("ch22", 55.8);
        map.put("ch23", 102.3);
        map.put("ch24", 12.3);
        map.put("ch25", 55.8);
        map.put("ch26", 102.3);
        map.put("ch27", 90.3);
        map.put("ch28", 1.8);
        map.put("ch29", 11.3);
        map.put("ch30", 100.3);*/

        shell.display(map);
        shell.shellSort(map);
        // shell.display(map);
        //shell.screening(map);

    }

}