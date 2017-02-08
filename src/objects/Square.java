package objects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import main.Window;

public class Square {
	
	public int x;
	public int y;
	public boolean l;
	/** -1 should be white, 0-360 corresponds to a hue value -2 is an unassigned value */
	public int c;
	
	public Square() {
		l = false;
		c = -1;
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
	public int neighboorcolor() {
		ArrayList<Integer> cs = new ArrayList<Integer>();
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
		if(cs.contains(-1) || cs.contains(-2)) {
			return -1;
		}
		Collections.sort(cs);
		int i = 0;
		int tolerance = 160;
		if(cs.get(1) - cs.get(0) >= tolerance + 10) {
			cs.set(0, cs.get(0) + 360);
		}
		if(cs.get(2) - cs.get(1) >= tolerance) {
			cs.set(0, cs.get(0) + 360);
			cs.set(1, cs.get(1) + 360);
		}
		for(int a : cs) {
			i += a;
		}
		return ((i + 1) /3) % 360;
	}
	
	
	public void draw(Graphics g, Window w) {
		int realX =  (int)(w.getFrameX() * (double)x / (double)Window.size + Window.PADDING_X);
        int realY =  (int)(w.getFrameY() * (double)y / (double)Window.size + Window.PADDING_Y);
        int realSize =  (int)(w.getFrameX() /(double)Window.size);
        g.fillRect(realX, realY, realSize, realSize);
	}
}
