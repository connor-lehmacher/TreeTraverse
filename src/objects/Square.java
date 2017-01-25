package objects;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Window;

public class Square {
	
	public int x;
	public int y;
	public boolean l;
	public Color1 c;
	
	public Square() {
		l = false;
		c = Color1.Dead;
		x = Window.sx;
		y = Window.sy;
		Window.squares[Window.sx][Window.sy] = this;
		if(Window.sx == Window.size - 1){
			Window.sx = 0;
			Window.sy++;
		} else{
			Window.sx++;
		}
	}
	
	public Square neighboor(int x,int y){
		return Window.squares[(this.x + x + Window.size) % Window.size][(this.y + y + Window.size) % Window.size]; 
	}
	
	public int neighboors() {
		int i = 0;
		i+= (neighboor(1,1).l ? 1 : 0);
		i+= (neighboor(0,1).l ? 1 : 0);
		i+= (neighboor(1,0).l ? 1 : 0);
		i+= (neighboor(-1,1).l ? 1 : 0);
		i+= (neighboor(1,-1).l ? 1 : 0);
		i+= (neighboor(-1,-1).l ? 1 : 0);
		i+= (neighboor(0,-1).l ? 1 : 0);
		i+= (neighboor(-1,0).l ? 1 : 0);
		return i;
	}
	
	@SuppressWarnings({ })
	public Color1 neighboorcolor() {
		ArrayList<Color1> cs = new ArrayList<Color1>();
		Square x;
		x = neighboor(0,1);
		if(x.l) cs.add(x.c);
		x = neighboor(1,0);
		if(x.l) cs.add(x.c);
		x = neighboor(-1,1);
		if(x.l) cs.add(x.c);
		x = neighboor(1,-1);
		if(x.l) cs.add(x.c);
		x = neighboor(1,1);
		if(x.l) cs.add(x.c);
		x = neighboor(-1,-1);
		if(x.l) cs.add(x.c);
		x = neighboor(-1,0);
		if(x.l) cs.add(x.c);
		x = neighboor(0,-1);
		if(x.l) cs.add(x.c);
		int i = 0;
		if(cs.contains(Color1.Blue) && cs.contains(Color1.Green) && cs.contains(Color1.Red)) {
			return Color1.Yellow;
		}
		if(cs.contains(Color1.Red) && cs.contains(Color1.Green) && cs.contains(Color1.Yellow)) {
			return Color1.Blue;
		}
		if(cs.contains(Color1.Blue) && cs.contains(Color1.Red) && cs.contains(Color1.Yellow)) {
			return Color1.Green;
		}
		if(cs.contains(Color1.Blue) && cs.contains(Color1.Green) && cs.contains(Color1.Yellow)) {
			return Color1.Red;
		}
		if(cs.contains(Color1.Yellow)){
			for(Color1 c: cs) {
				if( c == Color1.Yellow) i++;
			}
			if(i!=2) return Color1.Yellow;
		}
		if(cs.contains(Color1.Blue)){
			i = 0;
			for(Color1 c: cs) {
				if( c == Color1.Blue) i++;
			}
			if(i!=2) return Color1.Blue;
		}
		if(cs.contains(Color1.Red)){
			i = 0;
			for(Color1 c: cs) {
				if( c == Color1.Red) i++;
			}
			if(i!=2) return Color1.Red;
		}
		if(cs.contains(Color1.Green)){
			return Color1.Green;
		}
		//System.out.println("Error");
		return Color1.Dead;
	}
	
	
	public void draw(Graphics g, Window w) {
		int realX =  (int)(w.getFrameX() * (double)x / (double)Window.size + Window.PADDING_X);
        int realY =  (int)(w.getFrameY() * (double)y / (double)Window.size + Window.PADDING_Y);
        int realSize =  (int)(w.getFrameX() /(double)Window.size);
        g.fillRect(realX, realY, realSize, realSize);
	}
}
