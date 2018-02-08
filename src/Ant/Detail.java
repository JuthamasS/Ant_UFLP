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
public class Detail {
    int warehouse[];
    int openStatus[];
    
    public void setZero(int loop,int[] arr){
        for (int i = 0; i < loop; i++) {
            arr[i] = 0;
        }
    }
    public void setZero(int loop,double[] arr){
        for (int i = 0; i < loop; i++) {
            arr[i] = 0;
        }
    }
    public void setWarehouse(){
        this.warehouse = warehouse;
    }
    public int[] getWarehouse(){
        return warehouse;
    }
    public void setOpenStatus(){
        this.openStatus = openStatus;
    }
    public int[] getOpenStatus(){
        return openStatus;
    }
}
