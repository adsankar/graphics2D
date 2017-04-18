package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CircleClicker extends Canvas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame myFrame = new Frame();
		myFrame.setBackground(Color.black);
		CircleClicker c = new CircleClicker();
		myFrame.add(c);
		myFrame.setSize(800,800);
		myFrame.setTitle("This is the clicker");
		myFrame.setVisible(true);
		myFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public CircleClicker(){
		MouseListener m = new MouseListener() {
			int i=1;
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stud
			}
			
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
	
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				drawOval(getGraphics(),i, e.getX(), e.getY());
				i++;
			}
		};
		this.addMouseListener(m);
	}
	
	public void paint(Graphics g){

	}
	
	public void drawOval(Graphics g, int i,int x,int y){
		g.setColor(Color.red);
		g.drawOval(x-50,y-50,100,100);
		//i++;
	}
	

}
