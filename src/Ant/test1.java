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
public class test1 {
    public static void main(String[] args){
        double mincost = 7000;
        int[] minopen = new int[3];
        minopen[0] = 0;
        minopen[1] = 0;
        minopen[2] = 0;
        int j = 1;
        int k = 0;
        double C = 1234.56;
        int[] open = new int[3];
        open[0] = 1;
        open[1] = 0;
        open[2] = 1;
        
        
        if(j == 0){
            mincost = C;
            for (int i = 0; i < 3; i++) {
                minopen[i] = open[i];
            }
        }
        else{System.out.println("1111");
            if(C < mincost){ System.out.println("2222");
                mincost = C;System.out.println(mincost);
                for (int i = 0; i < 3; i++) {
                    minopen[i] = open[i];
                }
            }
        }
        System.out.println(C);
        for (int i = 0; i < 3; i++) {
            System.out.println(open[i] + " ");
        }
        System.out.println(mincost);
        for (int i = 0; i < 3; i++) {
            System.out.println(minopen[i] + " ");
        }
        
    }
}
