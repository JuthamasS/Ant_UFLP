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
public class Cost {
    private double minCost[];
    private int minOpening[];
    private int minIndex;
    
    public Cost(){
        
    }
    public Cost(int n){
        this.minCost = new double[n];
        this.minOpening = new int[n];
    }
    public double[] getMinCost(){
        return minCost;
    }
    public double getMinCost(int index){
        return minCost[index];
    }
    public void setMinCost(int index,double value){
        this.minCost[index] = value;
    }
    public int[] getMinOpening(){
        return minOpening;
    }
    public int getMinOpening(int index){
        return minOpening[index];
    }
    public void setMinOpening(int[] opening){
        this.minOpening = opening;
    }
    public void setMinOpening(int index,int value){
        this.minOpening[index] = value;
    }
    public void setMinIndex(int index){
        this.minIndex = index;
    }
    public int getMinIndex(){
        return minIndex;
    }
}
