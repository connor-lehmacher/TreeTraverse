package objects;

import java.awt.Color;

public enum Color1 {
	Red(Color.red), Yellow, Green, Blue, Dead;
	
	Color c;
	
	private Color1(Color c){
		this.c = c;
	}
	
	public static Color toColor() {
		return Color.red;
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
}
