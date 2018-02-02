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
import java.util.Map;
import static main.MainClass.uflp;
public class test3 {
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
        
        
        
        
    

