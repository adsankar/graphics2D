package more;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing2 extends JPanel {

	public void paint(Graphics g){
		g.setColor(Color.black);

		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.GREEN);
		
		g.drawRect(10, 10, 100, 100);
		g.fillRect(10,10,100,100);
		
		
		g.drawRect(110,110,100,100);
		g.setColor(Color.cyan);
		g.fillRect(110,110,100,100);
		
		g.setColor(Color.magenta);
		for (int i=0; i<getWidth(); i+=5){
			g.drawRect(20*i, 20*i, 50, 50);
		}
		g.drawOval(100, 200, 300, 300);
		g.drawPolygon(new int[]{20,40,60}, new int[] {50,20,30}, 3);
	}
	
	public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.setTitle("This is a drawing:");
	    frame.setSize(700, 700);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    Container contentPane = frame.getContentPane();
	    contentPane.add(new Drawing2());
	 
	    frame.setVisible(true);
	    
	  }
	

	
}
