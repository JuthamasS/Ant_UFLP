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

/**
 *
 * @author JuthamasS
 */
import java.util.ArrayList;
import java.text.DecimalFormat;
import static main.MainClass.uflp;
public class MainClass {
    static Scanner in = new Scanner(System.in);
    static ActionFiles file = new ActionFiles();
    static Locations location = new Locations();
    static ArrayList<Double> inputFile = null;
    static Properties textXml = new Properties();
    static ActionUFLP uflp = new ActionUFLP();
    static TestUFLP tUFLP = new TestUFLP();
    static Random random = new Random();
    static AntAction ant = new AntAction();
    static DecimalFormat df = new DecimalFormat("0.00000");
    
    public static void main(String[] args) throws IOException{
        //location.getLocations();  ///สร้างตำแหน่งของสถานีกับลูกค้า
        MainClass mc = new MainClass();
        textXml.loadFromXML(uflp.getXML()); //โหลดไฟล์xmlที่ไว้เก็บstring
        try {
            mc.inputFile = file.readFile("D:\\DistanceFile.txt");//D:\\test\\2\\3\\DistanceFile.txt
        } catch (Exception e) {
            System.err.println(textXml.getProperty("email.support"));
        }
        uflp.inputAll(mc.inputFile, textXml); //แสดงข้อมูล ระยะทางสถานีไปโกดัง ต้นทุนสถานี
        
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
        double p[] = new double[uflp.getN()];
        int opening[] = new int[uflp.getN()];
        int arrAns[] = new int[uflp.getN()];
        double summation;
        double W[] = new double[uflp.getN()];
        double C;
        System.out.println();
        System.out.println("---Ant System---");
        for(int i=0;i<n;i++){
            arrAns[i] = 0;
            W[i] = uflp.getW()[i];
        }
        for(int j=0;j<n;j++){
            System.out.println("รอบที่"+(j+1));
            summation = 0;
            ant.findProbability(n,summation,W,p,eta,T,alpha,beta);
            summation = ant.findSummation1(summation,p);
            System.out.println("sumT&ETA : " + summation);
            System.out.println("------------------------------");
            System.out.println("ค่า P หลังจากหารด้วย summation");
            ant.pDividedBySummation(p,summation);
            System.out.println("-------------------------------");
            ant.findPercentage(n, p, percentage);
            ant.findStation(n,percentage,arrAns,j);
            ant.choosingStation(opening, j);
        }
        ant.printCity(arrAns);
        System.out.println();
        ant.printStatus(opening);
        
        //----------------------------------------------------------------
        ant.checkWorstCase(n, opening);
        C = ant.findMin(n,opening,uflp);
        System.out.println();
        System.out.println("min : "+C);
    }
}
        
        
        
        
    

