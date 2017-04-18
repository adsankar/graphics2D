package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SankarBasicAWT extends Canvas{

	public static void main(String[] args){
	Frame myFrame = new Frame();
	myFrame.setSize(500,400);
	SankarBasicAWT c = new SankarBasicAWT();
	myFrame.add(c);
	myFrame.setVisible(true);
	myFrame.setTitle("A demonstration of my skills in drawing");
	myFrame.setBackground(new Color(50,50,255));
	myFrame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}//end windowClosing event
	});
	}
	
	public void paint(Graphics g){
		g.setColor(new Color(0,0,255));
		//g.fillRect(0,0,getWidth(),getHeight());
	
		g.setColor(Color.black);
		g.drawLine(0,0,getWidth(),getHeight());
		g.setColor(Color.magenta);
		g.drawString("Hello", 20, 30);
		g.translate(getWidth()/2, getHeight()/2);
		Color ItBrown = new Color(160,115,60);
		g.setColor(ItBrown);
		g.fillOval(-50,-50,100,100);
		g.translate(-getWidth()/2, -getHeight()/2);
		g.setColor(new Color(240,10,10));

		int r = (int) (Math.random()*(getHeight()));

		int [] x = {r,r+30,r-20};
		int [] y = {r-10,r,r+70, r+10};
		g.fillPolygon(x,y,3);
		float[] t = Color.RGBtoHSB(0, 35, 99, null);
		g.setColor(Color.lightGray);
		String stats = "Red: "+ItBrown.getRed()+" hue: "+t[0]+" saturation: "+ t[1]+" brightness: "+t[2];

		g.drawString(stats,
				getWidth()/2-(getFontMetrics(getFont()).stringWidth(stats)/2), 
				getHeight()-getFontMetrics(getFont()).getMaxDescent());
	}

}
