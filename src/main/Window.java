package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;

import listening.KeyBoard;
import listening.Mouse;
import objects.Square;

@SuppressWarnings("serial")
public class Window extends JFrame {
	//-------------Fields--------------//
    /** Initial Size of the frame: X */
    final static int FRAME_X = 745;
    /** Initial Size of the frame: Y */
    final static int FRAME_Y = 745;
    /** Padding for window size: X
     * ElCapitan: 0, Windows7: 8  */   
    public final static int PADDING_X;
    /** Padding for window size: Y
     * ElCapitan: 23, Windows7: 30  */ 
    public final static int PADDING_Y;
    
    public static int size = 729;
    public static Square[][] squares = new Square[size][size];
    public static boolean[][] changes = new boolean[size][size];
    public static int[][] cchanges = new int[size][size];
    static {
    	for(int i = 0; i < size ; i++) {
    		for(int j = 0; j< size ; j++) {
    			cchanges[i][j] = -2;
    		}
    	}
    }
    public static int sx = 0;
    public static int sy = 0;
    //Gives Values for padding based on OS
    static {
    	if (System.getProperty("os.name").equals("Mac OS X")) {
    		PADDING_X = 0;
    		PADDING_Y = 23;
    	}
    	else if (System.getProperty("os.name").equals("Windows 7")) {
    		PADDING_X = 8;
    		PADDING_Y = 30;
    	}
    	else {
    		System.err.println("OS Not Supported Yet");
    		PADDING_X = 0;
    		PADDING_Y = 0;
    	}
    }
    
    //Double Buffering
    private Image photo;
    private Graphics dbg;
    
    int frameX;
    int frameY;
   
    Mouse m;
    boolean mousePressed;
    KeyBoard k;
    ArrayList<Boolean> keysPressed = new ArrayList<Boolean>();

    //----------Constructor--------//
    /** Makes Frame Makes objects */
    public Window() {
        super();
        
        //Set up how the frame works
        setSize(FRAME_X , FRAME_Y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        
        m = new Mouse();
        addMouseListener(m);
        
        k = new KeyBoard();
        addKeyListener(k);
        
        for(int i = 0; i < Window.size * Window.size; i++) {
        	new Square();
        }
       
        /*squares[400][400].l = true;
        squares[399][400].l = true;
        squares[400][401].l = true;
        squares[401][400].l = true;
        squares[400][399].l = true;
        squares[401][402].l = true; 
        squares[399][402].l = true; 
        squares[401][398].l = true; 
        squares[399][398].l = true; 
        */ 
        
    	for(int i = 0; i < Window.size; i++) {
    		for(int j = 0; j < Window.size; j++) {
    			if(true /* Math.random() > 0.9 squares[i][j].l*/){
    				squares[i][j].l = true;
    				squares[i][j].c = (int)(Math.random() * 360); 
    			}
    		}
    	}
    	holes(729, squares, 0, 0, 50);
    } 
   
    //-----Methods--------//
    public void holes(int a, Square[][] b, int c, int d, int e) {
    	if(a == 3) {
    		b[c + 1][d + 1].l = false;
    	}
    	else {
    		for(int i = a/3 + c; i < 2*a/3 + c; i++) {
    			for(int j = a/3 + d; j < 2*a/3 + d; j++) {
    				b[i][j].l = false;
    			}
    		}
    		if(e > 1) {
    		holes(a/3, b, c, d, e-1);
    		holes(a/3, b, c + a/3, d, e-1);
    		holes(a/3, b, c + 2*a/3, d, e-1);
    		holes(a/3, b, c, d + a/3, e-1);
    		holes(a/3, b, c, d + 2*a/3, e-1);
    		holes(a/3, b, c +a/3, d+a/3, e-1);
    		holes(a/3, b, c + 2*a/3, d +2*a/3, e-1);
    		holes(a/3, b, c + 2*a/3, d +a/3, e-1);
    		holes(a/3, b, c + a/3, d +2*a/3, e-1);
    		}
    	}
    }
    /** Logic loop */
    public void run() {
    	while(true) {
            keysPressed = k.getKeysPressed();
    		mousePressed = m.getMousePressed();
    		try{
    			Thread.sleep(0);
    		} catch(InterruptedException i){}
    		/*
    		for(int i = 0; i < Window.size; i++) {
    			for(int j = 0; j < Window.size; j++) {
    				Square x = squares[i][j];
    				if(x.l){
    					if(x.neighboors() == 8 || x.neighboors() > 3){
    						changes[i][j] = true;
    					}
    				} else{
    					if(x.neighboors() == 3 || x.neighboors() == 3) {
    						changes[i][j] = true;
    						cchanges[i][j] = x.neighboorcolor();
    					}
    				}
    			}
    		}
    		for(int i = 0; i < Window.size; i++) {
    			for(int j = 0; j < Window.size; j++) {
    				if(changes[i][j]) {
    					squares[i][j].l = (squares[i][j].l ? false : true);
    					changes[i][j] = false;
    				}
    				if(!(cchanges[i][j] == -2)) {
    					squares[i][j].c = cchanges[i][j];
    					cchanges[i][j] = -2; 
    				}
    			}
    		}
    		*/
    	}
    }
    
    public int getFrameX() {
    	return this.getContentPane().getWidth();
    }
    
    public int getFrameY() {
    	return this.getContentPane().getHeight();
    }
    
    /** Double buffering */
    @Override
    public void paint(Graphics g) {
    	int frameX = (int)(this.getContentPane().getWidth() + PADDING_X + 1);
        int frameY = (int)(this.getContentPane().getHeight() + PADDING_Y + 1);
        photo = createImage(frameX, frameY);
        dbg = photo.getGraphics();
        paintComponent(dbg);
        g.drawImage(photo, 0, 0, this);
    }
    
    /** paint loop
     * draws rectangles/people */
    public void paintComponent(Graphics g) {   
    	g.setColor(Color.WHITE);
        for(int i = 0; i < Window.size; i++) {
        	for(int j = 0; j < Window.size; j++) {
        		final int c1 = squares[i][j].c;
        		if(c1 == -1) {
        			g.setColor(Color.WHITE);
        		} else if(c1 == -2) {
        			System.err.println("Ouch");
        		} else { 
        			g.setColor(hueToColor(messWithHue((double)c1)));
        		}
        		if(squares[i][j].l) {
        			squares[i][j].draw(g, this);
        		}
        	}
        }
        repaint();
    }
    
    public double messWithHue(double hue) {
    	double x = -0.00000006 * hue * hue * hue * hue
    			+ 0.00003403 * hue * hue * hue
    			- 0.00195823 * hue * hue
    			+ 0.30683021 * hue  
    			+ 0.7900432;
    	return x;
    }
    
    public Color hueToColor(double hue) {
    	hue = hue % 360;
    	double x = 1 - Math.abs((hue / 60.0) % 2.0 - 1.0);
    	int tester = (int)(hue / 60);
    	float red = 0;
    	float green = 0;
    	float blue = 0;
    	switch (tester){
    	case 0:
    		red = 1;
        	green = (float) x;
        	blue = 0;
    		break;
    	case 1:
    		red = (float) x;
        	green = 1;
        	blue = 0;
    		break;
    	case 2:
    		red = 0;
        	green = 1;
        	blue = (float) x;
    		break;
    	case 3:
    		red = 0;
        	green = (float) x;
        	blue = 1;
    		break;
    	case 4:
    		red = (float) x;
        	green = 0;
        	blue = 1;
    		break;
    	case 5:
    		red = 1;
        	green = 0;
        	blue = (float) x;
    		break;
    	}
    	return new Color(red, green, blue);
    }
}