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
    static DecimalFormat df = new DecimalFormat("0.00000");
    
    public static void main(String[] args) throws IOException{
        location.getLocations();  ///สร้างตำแหน่งของสถานีกับลูกค้า
        MainClass mc = new MainClass();
        textXml.loadFromXML(uflp.getXML()); //โหลดไฟล์xmlที่ไว้เก็บstring
        try {
            mc.inputFile = file.readFile("D:\\DistanceFile.txt");//D:\\test\\2\\3\\DistanceFile.txt
        } catch (Exception e) {
            System.err.println(textXml.getProperty("email.support"));
        }
        uflp.inputAll(mc.inputFile, textXml); //แสดงข้อมูล ระยะทางสถานีไปโกดัง ต้นทุนสถานี
        
        
        //-------------------------------------------------------------------------------
        double T[] = new double[uflp.getN()];
        double eta[] = new double[uflp.getN()];
        double percentage[] = new double[uflp.getN()]; 
        int alpha = 1;
        int beta = 2;
        int n = uflp.getN();
        double p[] = new double[uflp.getN()];
        int choosen = 0;
        int opening[] = new int[uflp.getN()];
        int arrAns[] = new int[uflp.getN()];
        //double pheromone[][] = new double[uflp.getN()][uflp.getN()];
        //char location[] = new char[10];
        
        double summation = 0;
        int numOfAnt = 3;
        int time = 2;
        int arrANS[][] = new int[uflp.getN()][numOfAnt];
        ArrayList<Integer> answer = new ArrayList<Integer>();
        System.out.println();
        System.out.println("---Ant System---");
        
//        for(int i=0;i<uflp.getN();i++){
//            for(int j=0;j<uflp.getN();j++){
//                pheromone[i][j] = 0.1;
//            }
//        }
        //-----------------------------------------------------------------------------
//        for(int k=0;k<time;k++){
            for(int j=0;j<uflp.getN();j++){
                System.out.println("รอบที่"+(j+1));
                summation = 0;
                //findT&ETA
                for(int i =0;i<uflp.getN();i++){
                    T[i] = 0.1;   
                    System.out.println("T"+(i+1)+" : "+T[i]); 
                    eta[i] = 1/uflp.getW()[i]; //(random.nextInt(2000)+1000.0);         //(1000 + (int)(Math.random() * (5000))
                    String output = df.format(eta[i]);
                    System.out.println("ต้นทุนแต่ละสถานี(w) : "+uflp.getW()[i]);
                    System.out.println("ETA"+(i+1)+" : "+eta[i]);
                    p[i] = (Math.pow(T[i], alpha)* Math.pow(eta[i], beta));    
                    summation += (Math.pow(T[i], alpha)* Math.pow(eta[i], beta));       
                    System.out.println("p"+(i+1)+" : "+p[i]);
                    //String x = df.format(summation);
                    System.out.println("sum : "+summation);
                    System.out.println("-------------------------------------");
                }
                System.out.println("sumT&ETA : " + summation);
                System.out.println("------------------------------");
                //-----------------------------------------------------------------------------
                System.out.println("ค่า P หลังจากหารด้วย summation");
                for(int i=0;i<uflp.getN();i++){
                    p[i] = p[i]/summation;      
                    System.out.println(p[i]);
                }System.out.println("-------------------------------");
                //---------------------------------------------------------------------------
                double temp = 0;
                for(int i=0;i<uflp.getN();i++){

                    if(i==0){
                        temp += p[0];
                        percentage[0] = p[0];
                        System.out.print("P"+(i+1) +" : "+p[0] + "  ");
                        System.out.println("ร้อยละP"+(i+1) +" : "+ percentage[0]);
                    }
                    else{
                        temp += p[i];
                        percentage[i] = temp;
                        System.out.print("P"+(i+1) +" : "+p[i] + "  ");
                        System.out.println("ร้อยละP"+(i+1) +" : "+ percentage[i]);    
                    }  
                }
                //------------------------------------------------------------------------------------
                double r1 = Math.random();
                System.out.println("ค่าสุ่มเลือกเมือง : "+r1);

                do{
                    boolean x = true;
                    for(int i=0;i<uflp.getN();i++){
                        if(r1<=percentage[i]){
                            choosen = i+1;
                            break;
                        }              
                    }
                    for(int k=0;k<uflp.getN();k++){
                        if(choosen == arrAns[k]){
                            x = true;
                        }
                    }
                }while(true);
                System.out.println("เมืองที่เลือก : " + choosen);  
                
                
                //--------------------------------------------------------------------------------
                double r2 = Math.random();
                
                System.out.println("ค่าสุ่มเลือกหรือไม่เลือกเมืองไปเป็นคำตอบ : "+r2);
                if(r2>=0.5){
                    opening[j] = 1;
                    System.out.println("เมืองนี้ถูกเลือกไปเป็นคำตอบ"+opening[j]);
                    System.out.println("#####################################");
                }else{
                    opening[j] = 0;
                    System.out.println("เมืองนี้ไม่ถูกเลือกไปเป็นคำตอบ"+opening[j]);
                    System.out.println("#####################################");
                }                  
            }
            //----------------------------------------------------------------------     
            
                for(int a:arrAns){
                    System.out.println(a+" ");
                }
                for(int b:opening){
                    System.out.println(b+" ");
                }
    
    }
}
        
        
        
        
    

