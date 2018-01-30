/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ant;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author JuthamasS
 */
public class test2 {
    public static void main(String[] args){
        System.out.println("123");
//        test2 t = new test2();
//        t.treeMapDemo();
    }
    public static void treeMapDemo(){
        TreeMap<Integer, String> m = new TreeMap<Integer, String>();
        m.put(001,"higiughiphp");
        m.put(002,"hgjhgjyghiphp");
        m.put(003,"fgfggfgg");
        m.put(004,"hiergrgergphp");
        m.put(005,"hdgsdhththp");
        
        for(Map.Entry<Integer, String> item : m.entrySet()){
            Integer key = item.getKey();
            String value = item.getValue();
            System.out.println(key+value);
        }
                
    }
}
