package graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawCirc3 extends JPanel{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JFrame frame = new JFrame();
	    frame.setTitle("This is a modern art:");
	    frame.setSize(900, 900);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    Container contentPane = frame.getContentPane();
	    contentPane.add(new DrawCirc3());
	 
	    frame.setVisible(true);
		
	}
	
	
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		for (int i=0; i<50; i++){
			g.setColor(new Color(255-3*i, 5*i, 0));
			g.drawOval(40, 40, 10+6*i,10+6*i);
		}
		for (int i=0; i<50; i++){
			g.setColor(new Color(255-5*i, 0, 4*i));
			g.drawOval(40, 345, 10+6*i,10+6*i);
		}
		for (int i=0; i<50; i++){
			g.setColor(new Color(4*i, 0, 255-3*1));
			g.drawOval(345, 40, 10+6*i,10+6*i);
		}
		for (int i=0; i<50; i++){
			g.setColor(new Color(10+4*i, 255-3*i, 255-3*1));
			g.drawOval(345, 345, 10+6*i,10+6*i);
		}
		
	}

}

