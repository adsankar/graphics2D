package graphics;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyDrawing extends Applet{


	public void paint(Graphics g){
		g.setColor(Color.BLUE);

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
		g.drawOval(500, 500, 300, 300);
		g.drawPolygon(new int[]{20,40,60}, new int[] {50,20,30}, 3);
		
		//add some more stuff for drawing
		//triangles
		//polygons
		//circles
		//fill
	}

	public static void main(String args[]){
		Applet applet = new MyDrawing();
		Frame frame = new Frame();
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		frame.add(applet);
		frame.setSize(600, 600);
	}
}
