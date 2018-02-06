/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ant;
import Ant.Cost;
/**
 *
 * @author JuthamasS
 */
public class test4 {
    public static void main(String[] args){
        Cost mincost = new Cost(3);
        Cost minopening[] = new Cost[3];
        
        for (int i = 0; i < 3; i++) {
            //mincost.minCost[i] = 10;
            minopening[i] = new Cost(3);
            for (int j = 0; j < 3; j++) {
                
                minopening[i].setMinOpening(j,20);
            }
            
        }
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    
}
