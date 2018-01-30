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
        int arr[] = new int[5];
        int x = 1;
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 5;
        arr[3] = 1;
        arr[4] = 0;
        
        
        boolean a =true;
        for(int i =0;i<5;i++){
            if(x == arr[i]){
                System.out.println("find");
            }
            else{
                a = false;
                arr[i] = x;
            }
        }
                 
    }
}
