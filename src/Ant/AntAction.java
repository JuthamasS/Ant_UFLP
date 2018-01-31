/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ant;

/**
 *
 * @author JuthamasS
 */
import java.text.DecimalFormat;
public class AntAction {
    
    
    public void findProbability(int n,double summation,double[] w,double[] p,double[] eta,double[] T,int alpha,int beta){
        DecimalFormat df = new DecimalFormat("0.00000");
        for(int i =0;i<n;i++){
            T[i] = 0.1;   
            System.out.println("T"+(i+1)+" : "+T[i]); 
            eta[i] = 1/w[i];      
            String output = df.format(eta[i]);
            System.out.println("ต้นทุนแต่ละสถานี(w) : "+w[i]);
            System.out.println("ETA"+(i+1)+" : "+eta[i]);
            p[i] = (Math.pow(T[i], alpha)* Math.pow(eta[i], beta));
            summation += (Math.pow(T[i], alpha)* Math.pow(eta[i], beta)); 
            System.out.println("p"+(i+1)+" : "+p[i]);
            //String x = df.format(summation);
            System.out.println("sum : "+summation);
            System.out.println("-------------------------------------");
        }
    }
    public double findSummation1(double summation,double[] p){
        for(int i=0;i<p.length;i++){
            System.out.println(p[i]);
            summation += p[i];
        }
        return summation;
    }    
    public double findSummation2(double summation,int n,double[] eta,double[] T,double alpha,double beta){
        for(int i =0;i<n;i++){
            summation += (Math.pow(T[i], alpha)* Math.pow(eta[i], beta)); 
        }
        return summation;
    }
    public void pDividedBySummation(double[] p,double summation){
        for(int i=0;i<p.length;i++){
            p[i] = p[i]/summation;      
            System.out.println(p[i]);
        }
    }
    public void findPercentage(int n,double[] p,double[] percentage){
        double temp = 0;
        for(int i=0;i<n;i++){
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
    }
    public void findStation(int n,double[] percentage,int[] arrAns,int j){
        boolean x = true;
        int choosen = 0;
        do{
            double r1 = Math.random();
            System.out.println("ค่าสุ่มเลือกเมือง : "+r1);
            for(int i=0;i<n;i++){
                if(r1<=percentage[i]){
                    choosen = i+1;
                    System.out.println(choosen);
                    break;
                }              
            }
            for(int k=0;k<(n-1);k++){
                if(choosen == arrAns[k]){
                    x = true;
                    break;
                }else{
                    x = false;
                }
            }arrAns[j] = choosen;
        }while(x);
        System.out.println("เมืองที่เลือก : " + choosen);
    }
    public void choosingStation(int[] opening,int j){
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
    public void printCity(int[] arrAns){
        System.out.print("เมือง        : ");
        for(int a:arrAns){
            System.out.print(a+" ");
        }
    }
    public void printStatus(int[] opening){
        System.out.print("เลือก/ไม่เลือก : ");
        for(int b:opening){
            System.out.print(b+" ");
        }
    }
    
}
