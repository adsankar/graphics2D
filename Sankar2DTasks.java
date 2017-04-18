package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Graphics2D Tasks
 * @author Aleksander Sankar
 * Graphics Pd. 1
 * Mr. Fowler
 */
public class Sankar2DTasks extends JPanel {

	/**
	 * This program creates a frame, draws some dingbats, and draws some color gradients.
	 * @param args not used
	 */
	public static void main(String[] args) {

		//create the frame, size it, and title it
		JFrame myFrame = new JFrame();
		myFrame.setTitle("Dingbat and Color Gradients");
		myFrame.setSize(850, 900);
		myFrame.setBackground(Color.white);
		//process for terminating the program when the x button is clicked
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//end window closing event
		});

		//instantiate the object and add it to the frame
		Sankar2DTasks s = new Sankar2DTasks();
		myFrame.add(s); 

		//show the frame
		myFrame.setVisible(true);

	}//end main

	/**
	 * Draws the first resizable dingbat when given the position to be drawn on and the size.
	 * @param g the graphics object used for drawing
	 * @param width the width of the dingbat 
	 * @param height the height of the dingbat
	 * @param x the x coordinate of the center of the dingbat
	 * @param y the y coordinate of the center of the dingbat
	 */
	public void drawDingbat(Graphics g, float width, float height, int x, int y){
		Graphics2D g2 = (Graphics2D)g; //create the Graphics2D object
		float[] dashing = {20,10,15,20};
		//set the stroke with to 1/20th the size of the dingbat, along with rounded caps (endings) and joints
		g2.setStroke(new BasicStroke((width+height)/40,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND, .5f, dashing,.7f));
		
		//draw the dingbat which consists of four lines
		int rounder = (int)((width/(2*Math.sqrt(2)))-width/2);
		g2.drawLine(x, y, x+(int)width, y+(int)height);// \
		g2.drawLine(x+(int)width/2, y+rounder, x+(int)width/2, y+(int)height-rounder);// |
		g2.drawLine(x+(int)width, y, x, y+(int)height);// /
		g2.drawLine(x+rounder, y+(int)height/2, x+(int)width-rounder, y+(int)height/2);;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;// --
	}//end drawDingbat

	/**
	 * Draws the second resizable dingbat, which uses quad curves, when given the position to be drawn on and the size.
	 * @param g the graphics object used for drawing
	 * @param width the width of the dingbat to be drawn
	 * @param height height of the dingbat shown
	 * @param x the x coordinate of the center of the dingbat
	 * @param y the y coordinate of the center of the dingbat
	 */
	public void drawDingbat2(Graphics g2, float width, float height, int x, int y){
		Graphics2D g = (Graphics2D)g2;//create the Graphics2D object
		float[] dashing = {20,10,15,20};
		//set the stroke with to 1/20th the size of the dingbat, along with rounded caps (endings) and joints
		g.setStroke(new BasicStroke((width+height)/40,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND, .5f, dashing,.7f));
		
		//draw the curved dingbat which consists of 4 quad curves
		g.draw(new QuadCurve2D.Float(x-width/2,y-height/2,x,y+height/2.5f,x+width/2,y+height/2));
		g.draw(new QuadCurve2D.Float(x+width/2,y-height/2,x,y+height/2.5f,x-width/2,y+height/2));
		g.draw(new QuadCurve2D.Float(x-width/2,y-height/2,x,y-height/2.5f,x+width/2,y+height/2));
		g.draw(new QuadCurve2D.Float(x+width/2,y-height/2,x,y-height/2.5f,x-width/2,y+height/2));
	}//end drawDingbat2

	/**
	 * Draws two dingbats and two curved dingbats at random locations in (400,400) with random colors and random sizes.
	 * Then some color gradients are drawn.
	 * @param Graphics g the graphics object used for drawing
	 */
	public void paint(Graphics g){
		g.drawString("Resize to draw shapes of different sizes and colors",10,50);
		Graphics2D g2 = (Graphics2D)g;//create the Graphics2D object
		
		//loop through twice so that two dingbats of each type are drawn
		for (int i=0; i<2; i++){
			//set to random color
			g2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			int r1 = (int)((Math.random()*400));//random x coordinate up to 400
			int r2 = (int)((Math.random()*400));//random y coordinate up to 400
			float size = (float)((Math.random()*200));//random size up to 200
			float size2 = (float)((Math.random()*200));//random size up to 200
			drawDingbat(g2,size,size2,r1,r2);//draw the dingbat at location generated
			//set to random color
			g2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			drawDingbat2(g2,size,size2,r1,r2);//draw the curved dingbat
		}//end for
		//make an acyclic purple to orange gradient
		GradientPaint gr = new GradientPaint(100,150,new Color(155,0,255),400,150,Color.orange,false);
		g2.setPaint(gr);//apply the color gradient
		g2.fill(new Rectangle2D.Double(100,500,400,100));//fill the rectangle
		
		//make a cyclic black-green-black gradient
		GradientPaint gr3 = new GradientPaint(50,0,Color.black,50,200,Color.green,true);
		g2.setPaint(gr3);//apply the color gradient
		g2.fill(new Rectangle2D.Double(700,200,100,400));//fill the rectangle
		
		//make an acyclic transparent to black gradient
		GradientPaint gr4 = new GradientPaint(0,0,new Color(0,0,0,0),700,700,Color.black,false);
		g2.setPaint(gr4);//apply the color gradient
		g2.fill(new Rectangle2D.Double(300,300,400,400));//fill the square
		
		//make a cyclic dark gray to white gradient
		GradientPaint gr2 = new GradientPaint(100,150,Color.darkGray,350,150,Color.white,true);
		g2.setPaint(gr2);//apply the color gradient		
		g2.fill(new Rectangle2D.Double(100,700,400, 100));//fill the rectangle
	}//end paint
	
	/*
	 * Winding path rules
	 * 
	 * 1. Even-Odd Rule: Construct a ray from the boundary outside of the shape to a specified point. 
	 * If the ray intersects an odd number of points (such as only the boundary) that point is not filled.
	 * If the ray intersects and even number of points, the indicated point is filled
	 * 
	 * 2. Non-Zero Rule: A shape can be drawn in one of two directions, clockwise and counterclockwise. 
	 * Clockwise is designated as having a value of 1 and a counterclockwise path is -1. When two shapes overlap
	 * their path values are added and if the result is zero, that portion is unfilled. Any result other than 0 is 
	 * filled.
	 * 
	 */
	

}//end class