package graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFlag extends JPanel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
	    frame.setTitle("I'm a flag:");
	    frame.setSize(800, 400);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    Container contentPane = frame.getContentPane();
	    contentPane.add(new DrawFlag());
	 
	    frame.setVisible(true);

	}
	
	public void drawStar(Graphics g, int center){
		
	}
	
	public void paint(Graphics g){
		int[] x = {0,266,0};
		int[] y = {0,200,400};
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 800, 400);
		g.setColor(Color.yellow);
		g.fillRect(0,133,800,134);
		
		g.setColor(Color.black);
		g.fillPolygon(x, y, 3);
	}

}
