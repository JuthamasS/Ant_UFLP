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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author Wirasinee
 */
public class RandomFunction {
    Random random;
    
    public static int[] combine(int[] a, int[] b, int lk) {
        int[] result = new int[a.length];
        System.arraycopy(a, 0, result, 0, lk);
        System.arraycopy(b, lk, result, lk, b.length - lk);
        return result;
    }

    public int randomZeroOrOne() {
        double r = random.nextDouble();
        if (r > 0.5) {
            return 1;
        } else {
            return 0;
        }
    }

    public int randomTo(int a, int b) {
        int c = random.nextInt(b) + a; System.out.println(c);
        return c;
    }
    
    public double randomDouble() {
        return random.nextDouble();
    }
    
    public double randomToDouble(int a, int b) {
        return random.nextDouble() +(random.nextInt(b) + a);
    }

    public Random getRandom() {
        return random;
    }

    
    
    
    
}
