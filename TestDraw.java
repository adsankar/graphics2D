package graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TestDraw extends JPanel {

	public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.setTitle("This is a test draw:");
	    frame.setSize(500, 500);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    Container contentPane = frame.getContentPane();
	    contentPane.add(new TestDraw());
	 
	    frame.setVisible(true);
	    
	  }
	public void paintComponent(Graphics g1){
		Graphics2D g = (Graphics2D) g1;
		GradientPaint gr = new GradientPaint(200,0,Color.blue,0,200,Color.magenta);

		g.setPaint(gr);
		g.fill(new Rectangle2D.Double(0,0,getWidth(),getHeight()));
		
		GradientPaint gr2 = new GradientPaint(100, 0, Color.green, 0, 100, Color.black);
		g.setPaint(gr2);
		g.fill(new Rectangle2D.Double(100,100,300, 300));
		
	}
	
}
