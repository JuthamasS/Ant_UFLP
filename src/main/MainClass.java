/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import pUflp.ActionFiles;
import pUflp.ActionUFLP;
import pUflp.Locations;
import pUflp.TestUFLP;
import java.util.Random; 
import Ant.AntAction;
import Ant.Cost;
import Ant.Detail;

/**
 *
 * @author JuthamasS
 */
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Map;
import static main.MainClass.uflp;
public class MainClass {
    final static long startTime = System.currentTimeMillis();
    static ActionFiles saveFile,saveSeed,creatD;
    static ArrayList<Double> inputFile = null;
    static ArrayList<String> inputFileCap = null;
    static ArrayList<Double> inputFileConfigCap = null;
    static Map<String, Double> inputFileAnswer = null;
    static ArrayList<Integer> inputFileSeed = null;
    static Properties textXml = new Properties();
    static ActionUFLP uflp = new ActionUFLP();
    static Scanner in = new Scanner(System.in);
    static ActionFiles file = new ActionFiles();
    static Locations location = new Locations();
    static TestUFLP tUFLP = new TestUFLP();
    static Random random = new Random();
    static AntAction ant = new AntAction();
    static DecimalFormat df = new DecimalFormat("0.00000");

    
    public static void main(String[] args) throws IOException{
        //location.getLocations();  ///สร้างตำแหน่งของสถานีกับลูกค้า
        MainClass mc = new MainClass();
        textXml.loadFromXML(uflp.getXML()); //โหลดไฟล์xmlที่ไว้เก็บstring
        
//        ArrayList<String> pathFiles = new ArrayList<>();
//        String directoryName = "D:\\test\\Istanze";
//        file.listPathFile(directoryName, pathFiles);
//        System.out.println(pathFiles);
//        inputFileAnswer = file.readFileMap("D:\\test\\Istanze\\uncapopt.txt"); // อ่านไฟล์คำตอบเก็บไว้
        
        
        try {
            mc.inputFile = file.readFile("D:\\DistanceFile.txt");//D:\\test\\2\\3\\DistanceFile.txt
            
            //String pathFileCap = pathFiles.get(f);//"D:\\test\\Istanze\\cap71.txt";//pathFiles.get(f);
            //mc.inputFileCap = file.readFile(pathFileCap);//D:\\test\\2\\3\\DistanceFile.txt///"D:\\DistanceFile.txt"//"D:\\cap71.txt"
//            nameFile = pathFileCap.substring(pathFileCap.lastIndexOf("\\") + 1, pathFileCap.length());
//            nameFile = nameFile.substring(0, nameFile.indexOf("."));
//            creatD = new ActionFiles();
//            creatD.creatingDirectory(addressFolder + "\\seed");
//            creatD.creatingDirectory(addressFolder + "\\summarize");
//            saveSeed = new ActionFiles(addressFolder + "\\seed\\seed_" + nameFile + ".txt");  //สร้างไฟล์เก็บseed
//            directoryCap = addressFolder + "\\" + nameFile;  //ที่อยู่โฟลเดอร์ที่จะสร้างไว้เก็บtxtแต่ละcap
//            creatD.creatingDirectory(directoryCap);         //สร้างโฟลเดอร์
//            mc.inputFileConfigCap = file.readFileDouble(addressFolder + "\\config\\config_" + nameFile + ".txt");//อ่านไฟล์ config แต่ละ cap
        } catch (Exception e) {
            System.err.println(textXml.getProperty("email.support"));
        }
        uflp.inputAll(mc.inputFile, textXml); //แสดงข้อมูล ระยะทางสถานีไปโกดัง ต้นทุนสถานี
        //int numFile = inputFileConfigCap.get(index++).intValue();//จำนวนไฟล์ที่จะสร้าง
        
        double meanBestFitness = 0;//ค่าเฉลียฟิสเนส
        double standardDeviation = 0;//ค่าเบียนเบน
        double sumXPowTwo = 0; //ไว้หาส่วนเบียนเบน
        double sumX = 0;//ผลรวมของx
            
        //------คำนวณ ant ความน่าจะเป็นที่จะเลือกเมือง----------------------------------
        double T[] = new double[uflp.getN()];
        double eta[] = new double[uflp.getN()];
        double percentage[] = new double[uflp.getN()]; 
        
        int alpha = 1;
        int beta = 2;
        int n = uflp.getN();
        int m = uflp.getM();
        double p[] = new double[n];
        int opening[] = new int[n];   //ต้องรีค่าใหม่ตลอดเเล้วค่อยเอาไปเท่ากับคลาส detail
        int[] arrAnsStation = new int[n];    //ต้องรีค่าใหม่ตลอดเเล้วค่อยเอาไปเท่ากับคลาส detail
        double summation;
        double W[] = new double[n];
        double C = 0;
        int numOfAnt = 5;  //30
        int round = 1;   //100Gen
        Cost mincost = new Cost(round);
        Cost minopening[] = new Cost[round];
        Cost minindex = new Cost();
        double bestMinCost = Integer.MAX_VALUE;
        int bestMinOpening[] = new int[n];
        Detail detail = new Detail();
        int loop;
        
        System.out.println();
        System.out.println("---Ant System---");
        for(int i=0;i<n;i++){
            arrAnsStation[i] = 0;
            W[i] = uflp.getW()[i];
        }
        for(int k = 0;k<round;k++){
            minopening[k] = new Cost(n);
            System.out.print("---");
            System.out.print("การเดินรอบที่ "+(k+1));
            System.out.println("---");
            for(int j = 0;j<numOfAnt;j++){
                detail.setZero(n,opening);
                detail.setZero(n, arrAnsStation);
                System.out.print("---");
                System.out.print("มดตัวที่ "+(j+1));
                System.out.println("---");
                for(int i=0;i<n;i++){
                    System.out.print("---");
                    System.out.print("สถานีที่"+(i+1));
                    System.out.println("---");
                    summation = 0;
                    ant.findProbability(n,summation,W,p,eta,T,alpha,beta);
                    summation = ant.findSummation1(summation,p);
                    ant.pDividedBySummation(p,summation);
                    ant.findPercentage(n, p, percentage);
                    ant.displayPercentage(n,percentage);
                    ant.findStation(n,percentage,arrAnsStation,i);
                }
                ant.choosingStation(opening,arrAnsStation);
                ant.printCity(arrAnsStation);
                System.out.println();
                ant.printStatus(opening);
                System.out.println();
                opening = ant.checkWorstCase(n, opening);
                System.out.println();
                int open[] = new int[n];
                open = opening;
                C = ant.findCost(n,m,k,open,uflp);  //เอาจาก opening ไปคิด
                System.out.println("ต้นทุนและค่าใช้จ่ายของมดตัวที่ " + (j+1) +" : " + C);
                System.out.println("-------------------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println(open[i]);
                }
//                mincost.setMinCost(k,C);
//                minopening[k].setMinOpening(opening);

               
                //---------------------------------------------------------
                ant.checkMinCost(j,k,C,opening,mincost,minopening,minindex); //จบรอบเเล้วก็หา minCostของรอบที่ j
            }
            //ant.checkBestMinCost(k,mincost,minopening,bestMinCost, bestMinOpening);
            
            
            //-------update pheromone after here---------------
        }
        
        
        
        
    }
    
//    public static void main(String[] args){  // เอาไว้ test กรณีที่ไม่ถูกเปิดโกดังเลย
//        int[] open = new int[3];
//        open[0] = 0;
//        open[1] = 0;
//        open[2] = 0;
//        System.out.println("1");
//        ant.checkWorstCase(3,open);
//        System.out.println("10");
//        for(int i=0;i<3;i++){
//            System.out.println(open[i]);
//        }
//    }
}
        
        
        
        
    

