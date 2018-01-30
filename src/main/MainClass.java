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
        double summation;
        int round = uflp.getN();
        double W[] = new double[uflp.getN()];
        
        
        System.out.println();
        System.out.println("---Ant System---");
        
        for(int i=0;i<uflp.getN();i++){
            arrAns[i] = 0;
            W[i] = uflp.getW()[i];
        }
        
        //-----------------------------------------------------------------------------

            for(int j=0;j<round;j++){
                System.out.println("รอบที่"+(j+1));
                summation = 0;
                ant.findEquation(n,W,eta,T,alpha,beta);
                summation = ant.findSummation1(p);
                System.out.println("sumT&ETA : " + summation);
                System.out.println("------------------------------");
                //-----------------------------------------------------------------------------
                System.out.println("ค่า P หลังจากหารด้วย summation");
                ant.pDividedBySummation(p,summation);
                System.out.println("-------------------------------");
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
                
                
                
                boolean x = true;
                do{
                    double r1 = Math.random();
                    System.out.println("ค่าสุ่มเลือกเมือง : "+r1);
                    for(int i=0;i<uflp.getN();i++){
                        if(r1<=percentage[i]){
                            choosen = i+1;
                            System.out.println(choosen);
                            break;
                        }              
                    }
                    for(int k=0;k<(uflp.getN()-1);k++){
                        if(choosen == arrAns[k]){
                            x = true;
                            break;
                        }else{
                            x = false;
                        }
                    }arrAns[j] = choosen;
                }while(x);
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
                ant.printCity(arrAns);
                System.out.println();
                ant.printStatus(opening);
    
    }
}
        
        
        
        
    

