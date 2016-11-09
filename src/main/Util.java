package main;

import java.awt.Color;
import java.math.BigInteger;
import java.util.Random;

/**
 * All Static Utility "Functions" 
 * @author Connor Lehmacher
 */
public class Util {
	/** Finds the square (a * a) of some double */
	public static double sq(double a) {
		return a * a;
	}
	
    /** Generates a new random color using random source r */
    public static Color randomColor(Random r) {
    	return new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }
    
    public static boolean isNearZero(double x) {
    	final double EPSILON = Double.MIN_NORMAL * 1000000;
    	return x > -EPSILON && x < EPSILON;
   }

    public static BigInteger binomial(BigInteger n, BigInteger k) {
    	if(n == k || k==BigInteger.ZERO){
    		return BigInteger.ONE;
    	}

    	BigInteger a = BigInteger.ONE;
    	if(k.compareTo(n.divide(new BigInteger("2"))) == -1) {
    		k = n.subtract(k);
    	}
    	for(BigInteger i = n ; i.compareTo(k) == 1; i = i.subtract(BigInteger.ONE)) {
    		a = a.multiply(i);
    	}
    	return(a.divide(factorial(n.subtract(k))));
    }

    public static BigInteger factorial(BigInteger n){
    	if(n.compareTo(new BigInteger("2")) == -1 ){
    		return BigInteger.ONE;
    	}
    	else return (n.multiply((factorial(n.subtract(BigInteger.ONE)))));
    }
}
