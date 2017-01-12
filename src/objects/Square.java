package objects;

import java.awt.Graphics;

import main.Window;

public class Square {
	
	public int x;
	public int y;
	public boolean l;
	
	public Square() {
		l = true;
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
		return Window.squares[this.x + x][this.y + y]; 
	}
	
	
	public void draw(Graphics g, Window w) {
		int realX =  (int)(w.getFrameX() * (double)x / (double)Window.size + Window.PADDING_X);
        int realY =  (int)(w.getFrameY() * (double)y / (double)Window.size + Window.PADDING_Y);
        int realSize =  (int)(w.getFrameX() /(double)Window.size);
        g.fillRect(realX, realY, realSize, realSize);
	}
}
