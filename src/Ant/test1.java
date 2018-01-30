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
import java.util.Random;

public class test1 {
    public static void main(String[] args){
        Random ran = new Random();
        double arr[] = new double[5];
        double sum[] = new double[5];
        for(int i=0;i<5;i++){
            arr[i] = ran.nextDouble();System.out.println(arr[i]); 
            if(i==0){
                sum[i] = arr[i];
            }
            else{
                sum[i] = (sum[i-1]+sum[i]);
            }System.out.println(sum[i]); 
        }  
//        double x = ran.nextDouble();
//        if(){
//                    arr[i] = i+1;
//                    System.out.println("i+1");
//                    
//                }
    }
}
