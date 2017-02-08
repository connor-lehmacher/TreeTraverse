package objects;

import java.awt.Color;

public enum Color1 {
	Red(Color.red, 0), Yellow(Color.yellow, 90), Green(Color.green, 180), Blue(Color.blue, 270), Dead(Color.white, -1); 
	
	Color c;
	int ci;
	
	private Color1(Color c, int ci){
		this.c = c;
		this.ci = ci;
	}
	
	public Color toColor() {
		return c;
	}
	public static Color1 random(){
		double x= Math.random();
		if(x<0.25){
			return Red;
		}
		if(x<0.5){
			return Yellow;
		}
		if(x<0.75){
			return Green;
		}
		else{
			return Blue;
		}
	}
	public int toInt() {
		return ci;
	}
}
