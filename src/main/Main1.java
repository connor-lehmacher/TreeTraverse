package main;

import javax.swing.SwingUtilities;

/**
 * Main Class
 * @author Connor Lehmacher
 */
public class Main1 {     
    /**
     * Main Method
     */
    public static void run() {
    	Window w = new Window();
    	try {
    		SwingUtilities.invokeAndWait(() -> w.setVisible(true));
    	} catch (Exception e) {}
    	w.run();
    }
}



