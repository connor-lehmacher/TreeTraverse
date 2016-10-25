package objects;

import java.awt.Graphics;

import main.Vector;
import main.Window;

public class Square {
	public double size;
	public Vector location;
	
	public Square(Vector location, double size) {
		this.size = size;
		this.location = location;
		Window.squares.add(this);
	}
	
	public void draw(Graphics g, Window w) {
		int realX =  (int)(w.getFrameX() * location.x + Window.PADDING_X);
        int realY =  (int)(w.getFrameY() * location.y + Window.PADDING_Y);
        int realSize =  (int)(w.getFrameX() * size);
        g.fillRect(realX, realY, realSize, realSize);
	}
}
