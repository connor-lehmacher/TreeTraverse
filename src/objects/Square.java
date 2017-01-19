package objects;

import java.awt.Color;
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
	
	@SuppressWarnings({"unchecked" })
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
		if(cs.contains(Color1.Red) && !cs.contains(Color1.Yellow)) {
			ArrayList<Color1> cs1 = (ArrayList<Color1>) cs.clone();
			cs1.remove(Color1.Red);
			cs1.remove(Color1.Red);
			cs1.remove(Color1.Blue);
			cs1.remove(Color1.Blue);
			if(cs1.size() == 2) {
				return Color1.Blue;
			} else return Color1.Yellow;
		}
		if(cs.contains(Color1.Yellow) && !cs.contains(Color1.Green)) {
			ArrayList<Color1> cs1 = (ArrayList<Color1>) cs.clone();
			cs1.remove(Color1.Yellow);
			cs1.remove(Color1.Yellow);
			cs1.remove(Color1.Red);
			cs1.remove(Color1.Red);
			if(cs1.size() == 2) {
				return Color1.Red;
			} else return Color1.Green;
		}
		if(cs.contains(Color1.Green) && !cs.contains(Color1.Blue)) {
			return Color1.Blue;
		}
		if(cs.contains(Color1.Blue) && !cs.contains(Color1.Red)) {
			return Color1.Red;
		}
		System.out.println("Error");
		return Color1.Blue;
	}
	
	
	public void draw(Graphics g, Window w) {
		int realX =  (int)(w.getFrameX() * (double)x / (double)Window.size + Window.PADDING_X);
        int realY =  (int)(w.getFrameY() * (double)y / (double)Window.size + Window.PADDING_Y);
        int realSize =  (int)(w.getFrameX() /(double)Window.size);
        g.fillRect(realX, realY, realSize, realSize);
	}
}
