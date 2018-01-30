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
    private double[] p;
    private double summation;
    
    public void findEquation(int n,double[] w,double[] eta,double[] T,int alpha,int beta){
        DecimalFormat df = new DecimalFormat("0.00000");
        for(int i =0;i<n;i++){
            T[i] = 0.1;   
            System.out.println("T"+(i+1)+" : "+T[i]); 
            eta[i] = 1/w[i];                       //(random.nextInt(2000)+1000.0);         //(1000 + (int)(Math.random() * (5000))
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
    public double findSummation1(double[] p){
        for(int i=0;i<p.length;i++){
            summation += p[i];
        }
        return summation;
    }    
    public double findSummation2(int n,double[] eta,double[] T,double alpha,double beta){
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
    public void findPercentage(){
        
    }
    public void findCity(){
        
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
    public void getP(){
        
    }
    public void setP(){
        
    }
    public double getSummation(){
        return summation;
    }
    public void setSummation(double summation){
        this.summation = summation;
    }
}
