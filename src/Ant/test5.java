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
public class test5 {
    public static void main(String[] args){
        int n = 2;
        int m = 3;
        int[] w = new int[n];
        int[][] cost = new int[n][m];
        
        w[0] = 20;
        w[1] = 10;  
        
        cost[0][0] = 15;
        cost[0][1] = 30;
        cost[0][2] = 10;
        
        cost[1][0] = 10;
        cost[1][1] = 25;
        cost[1][2] = 20;
        
        int minDistance = 1000;
        int[] open = new int[2];
        open[0] = 1;
        open[1] = 0;
       
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(open[j] == 1){
                    if(<= ){
                        
                    }
                }
            }
        }
    }
}
