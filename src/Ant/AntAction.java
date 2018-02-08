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
import java.util.Properties;
import pUflp.ActionUFLP;
import pUflp.TestUFLP;
import java.util.Random;

public class AntAction {
    
    static double sumW = 0;   //ต้นทุนรวม
    
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
            System.out.println("s"+(i+1)+"   : "+p[i]);
            //String x = df.format(summation);
            System.out.println("sum  : "+summation);
            System.out.println("-------------------------------------");
        }
    }
    public double findSummation1(double summation,double[] p){
        for(int i=0;i<p.length;i++){
            //System.out.println(p[i]);
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
        System.out.println("ค่า S หลังจากหารด้วยค่า summation");
        for(int i=0;i<p.length;i++){
            p[i] = p[i]/summation;      
            //System.out.println(p[i]);
        }
    }
    public void findPercentage(int n,double[] p,double[] percentage){
        System.out.println("ร้อยละของค่า S");
        double temp = 0;
        for(int i=0;i<n;i++){
            if(i==0){
                temp += p[0];
                percentage[0] = p[0];
                System.out.print("S"+(i+1) +" : "+p[0] + "  ");
                System.out.println("ร้อยละS"+(i+1) +" : "+ percentage[0]);
            }
            else{
                temp += p[i];
                percentage[i] = temp;
                System.out.print("S"+(i+1) +" : "+p[i] + "  ");
                System.out.println("ร้อยละS"+(i+1) +" : "+ percentage[i]);    
            }  
        }
        System.out.println("-------------------------------------");
    }
    public void displayPercentage(int n,double[] percentage){
        System.out.println("ช่วงของค่า S");
        System.out.println("0.0000000000000000  <=  S1  <=  " + percentage[0]);
        for (int i = 0; i < (n-1); i++) {
            System.out.println(percentage[i] + "  <   S" + (i+2) + "  <=  " + percentage[i+1]);
        }
        //System.out.println(percentage[n-1] + "  <=  P" +(n) +"<=  1.0000000000000000");
    }
    public void findStation(int n,double[] percentage,int[] arrAns,int j){
        boolean x = true;
        int choosen = 0;
        do{
            double r1 = Math.random();
            System.out.println("ค่าสุ่มเลือกสถานี  : "+r1);
            for(int i=0;i<n;i++){
                if(r1<=percentage[i]){
                    choosen = i+1;
                    System.out.println("สถานีที่ถูกสุ่มเลือก : " + choosen);
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
        System.out.println("สถานีที่เลือก : " + choosen);
        System.out.println("-------------------------------------");
    }
    public void choosingStation(int[] opening,int[] arrAnsStation){
        for (int i = 0; i < arrAnsStation.length; i++) {
            double r2 = Math.random();
            System.out.println("ค่าสุ่มเลือกหรือไม่เลือกสถานีไปเป็นคำตอบ : "+r2);
            if(r2>=0.5){
                opening[(arrAnsStation[i]-1)] = 1; 
                System.out.println("สถานีที่ " + arrAnsStation[i] + " ถูกเลือกไปเป็นคำตอบ");
                System.out.println("-------------------------------------");
            }else{
                opening[(arrAnsStation[i]-1)] = 0;
                System.out.println("สถานีที่ " + arrAnsStation[i] + " ไม่ถูกเลือกไปเป็นคำตอบ");
                System.out.println("-------------------------------------");
            }
        }
    }
    public void printCity(int[] arrAns){
        System.out.print("สถานี       : ");
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
    public double findCost(int n,int m,int[] opening,ActionUFLP uflp){
        TestUFLP u = new TestUFLP();
        double[][] distance = uflp.getDistance();
        double[] w = uflp.getW();
        int[][] statusNearCustomer = new int[uflp.getN()][uflp.getM()];
        int[] contectPeopleStatus = new int[uflp.getM()];
        double C = Integer.MAX_VALUE;
        int[] J = new int[n];     //ลูกค้าที่ถูกเลือกgเป็นลูกค้าคนที่เท่าไหร่
        double sumMinDistance = 0;
        double[] min = new double[uflp.getM()];
        int[] openStatus = new int[uflp.getN()];
        
        
        for(int j=0;j<m;j++){  //สถานี
            double minDistance = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){ //ลูกค้า
                if(opening[i] == 1){ 
                    if(distance[j][i] < minDistance){  //ลูกค้าคนที่ 0 สถานีที่ 0 1 2
                        minDistance = distance[j][i];
                        //statusNearCustomer[j][i] = 1;   //เอาไว้นับว่าเเต่ละสถานีมีลูกค้ากี่คน
//                        for (int z = i - 1; z >= 0; z--) {
//                            statusNearCustomer[j][z] = 0;  //รีสถานีที่ไม่ได้เลือกเปนสถานีที่น้อยที่สุดแล้ว
//                        }
                    }
                }
            }
//            for (int c = 0; c < uflp.getN(); c++) {
//                if (statusNearCustomer[j][c] >= 1) {
//                    contectPeopleStatus[c] += statusNearCustomer[j][c]; //ดูว่ามีลูกค้ากี่ค้นเลือกโกดังที่เปิดแต่ละกรณี
//                }
//            }
            min[j] = minDistance; //จะได้ระยะทางเส้นทางสั่นสุดของแต่ละลูกค้า
            sumMinDistance += min[j];
            System.out.println(min[j]);
        }
        
        System.out.println("----**");
        sumW = 0;//ผลรวมต้นทุน
        for(int i = 0;i<uflp.getN();i++) {
            if(opening[i] == 1) {
                sumW += w[i];               //หาต้นทุนการเปิดโกดัง
                System.out.println(w[i]);
            }
        }
        if((sumW + sumMinDistance) < C) {
            C = sumW + sumMinDistance;
            openStatus = opening.clone();    //ต้องโคลนเอาไว้ค่าจะได้ไม่เปลี่ยน
        }
        return C;
    }
    public int[] checkWorstCase(int n,int[] opening){      //กรณีที่ไม่มีสถานีใดถูกเปิดเลย [0,0,0]
        boolean print = false;
        RandomFunction ran = new RandomFunction();
        Random random = new Random();
        int value1 = 0;     //ไว้นับว่ามีเลข1กี่ตัวใน[] เช่น[0,1,1] => 2ตัว
        int value0 = 0;     //ไว้นับว่ามีเลข0กี่ตัวใน[] เช่น[0,1,1] => 1ตัว
        
        for (int i = 0;i<n;i++){ 
            if(opening[i] == 1){            //ถ้ามีเลข1ก็นับไว้
                value1++;
            } 
            else{
                value0++;
            }
        }
        if(value0 == n){            //ถ้าเป็น[0,0,0] ควรที่จะสุ่มใหม่
            print = true;
            int x = random.nextInt(n)+1;
            for(int j = 0;j<x;j++) {
                int indexOne = random.nextInt(n);;
                opening[indexOne] = 1;
                value1++;
            }
        }
        if(print){
            System.out.print("             ");
            for (int i = 0; i < n; i++) {
                System.out.print(opening[i] + " ");
            }
        }
        return opening;
    }
    public void checkMinCost(int j,int k,double C,int[] opening,Cost mincost,Cost[] minopening){
        if(j == 0){
            mincost.setMinCost(0, C);
            minopening[0].setMinOpening(opening);
        }
        else{
            if(C<mincost.getMinCost(k)){
                mincost.setMinCost(k, C);
                for(int i=0;i<opening.length;i++){
                    minopening[0].setMinOpening(opening);
                }
            }
        }
        System.out.println("Min Cost        : " + mincost.getMinCost(k));
        System.out.print("Min Open Status : ");
        for (int i = 0; i < opening.length; i++) {
            System.out.print(minopening[k].getMinOpening(i) + " ");
        }
        System.out.println();
        System.out.println("#####################################");
    }
    public void checkBestMinCost(int k,Cost mincost,Cost[] minopening,double bestMinCost,int[] bestMinOpening){
        if(k == 0){
            bestMinCost = mincost.getMinCost(0);
            bestMinOpening = minopening[0].getMinOpening();
        }
        else{   
            if(mincost.getMinCost(k)<bestMinCost){
                bestMinCost = mincost.getMinCost(k);
                bestMinOpening = minopening[k].getMinOpening();
            }
        }
        System.out.println("Best Min Cost        : " + bestMinCost);
        System.out.print("Best Min Open Status : ");
        for (int i = 0; i < bestMinOpening.length; i++) {
            System.out.print(bestMinOpening[i] + " ");
        }
        System.out.println();
        System.out.println("#####################################");
    }
        
}
