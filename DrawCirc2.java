package graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Draw a rainbow circle with fading effects.
 * @author Aleksander Sankar
 * Analysis of Algorithms Pd. 9
 * BADASS VERSION
 */
public class DrawCirc2 extends JPanel {

	@SuppressWarnings("deprecation")//f**k the police
	/**
	 * Instantiate a JFrame, and add a picture to it, then displays it.
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
	    frame.setTitle("This is a modern art:");
	    frame.setSize(1270, 600);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }//end windowClosing event
	    });
	    Container contentPane = frame.getContentPane();
	    contentPane.add(new DrawCirc2());
	    frame.show();//hells yeah
	  }//end main
	
	/**
	 * Paint the picture of the rainbow circles. 
	 */
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
	
		//#YOLO 
		//#SWAGT 
		for (int i=0; i<600; i++){
			g.setColor(new Color(15+4*i/10,i/10,i/10));//red
			g.fillOval(100+1*i,100+1*i, 400-2*i, 400-2*i);
		}//end for
		for (int i=0; i<600; i++){
			g.setColor(new Color(10+4*i/10,2*i/10,i/10));//orange
			g.fillOval(250+1*i,100+1*i, 400-2*i, 400-2*i);
		}//end for
		for (int i=0; i<600; i++){
			g.setColor(new Color(10+4*i/10,10+4*i/10,2*i/10));//yellow
			g.fillOval(400+1*i,100+1*i, 400-2*i, 400-2*i);
		}//end for	
		for (int i=0; i<600; i++){
			g.setColor(new Color(i/10,15+4*i/10,4*i/10));//green
			g.fillOval(550+1*i,100+1*i, 400-2*i, 400-2*i);
		}//end for
		for (int i=0; i<600; i++){
			g.setColor(new Color(i/10,2*i/10,10+4*i/10));//blue
			g.fillOval(700+1*i,100+1*i, 400-2*i, 400-2*i);
		}//end for
		for (int i=0; i<600; i+=1){
			g.setColor(new Color(4*i/10,2*i/10,10+4*i/10));//purple
			g.fillOval(850+i,100+i, 400-2*i, 400-2*i);
		}//end for
	
		g.setColor(Color.gray);
		g.setFont(new Font("",Font.ITALIC, 8));
		g.drawString("Aleksander Sankar", 50, 550);
		
	}//end paint method 
	
}//end class
