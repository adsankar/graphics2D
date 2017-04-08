package graphics;




import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawCirc extends JPanel {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.setTitle("This is a modern art:");
	    frame.setSize(1400, 600);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    Container contentPane = frame.getContentPane();
	    contentPane.add(new DrawCirc());
	 
	    frame.show();//trolololo
	    
	  }
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
	
		
		for (int i=0; i<600; i++){
			g.setColor(new Color(10+4*i/10,i/10,i/10));//red
			g.fillOval(100+1*i,100+1*i, 400-2*i, 400-2*i);
		}
		for (int i=0; i<600; i++){
			g.setColor(new Color(10+4*i/10,2*i/10,i/10));//orange
			g.fillOval(250+1*i,100+1*i, 400-2*i, 400-2*i);
		}
		for (int i=0; i<600; i++){
			g.setColor(new Color(10+4*i/10,10+4*i/10,2*i/10));//yellow
			g.fillOval(400+1*i,100+1*i, 400-2*i, 400-2*i);
		}		
		for (int i=0; i<600; i++){
			g.setColor(new Color(i/10,10+4*i/10,4*i/10));//green
			g.fillOval(550+1*i,100+1*i, 400-2*i, 400-2*i);
		}
		for (int i=0; i<600; i++){
			g.setColor(new Color(i/10,2*i/10,10+4*i/10));//blue
			g.fillOval(700+1*i,100+1*i, 400-2*i, 400-2*i);
		}
		for (int i=0; i<600; i++){
			g.setColor(new Color(4*i/10,2*i/10,10+4*i/10));//purple
			g.fillOval(850+1*i,100+1*i, 400-2*i, 400-2*i);
		}
	
	}
	
}
