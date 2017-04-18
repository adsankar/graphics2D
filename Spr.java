package pack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Spr extends JPanel implements Runnable{

	private final static int HORIZONTAL_SIZE = 800;
	private final static int VERTICAL_SIZE = 800;
	
	private static double loop = 40;
	private static double speed = .5;
	private Image bgImage;
	private static int count = 0;
	private static Thread myThread;
	private static Point2D.Double p;
	private static Point2D.Double p2;
	private static Point2D.Double cent;
	private static Color c1;
	private static Color c2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("A Spiral");// set the title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Spr());
		frame.pack();
		frame.setVisible(true);// show the animation
	}

	public Spr() {
		this.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
		
			public void mouseClicked(MouseEvent e) {
			setColors();
				
			}
		});
		
		this.setPreferredSize(new Dimension(HORIZONTAL_SIZE, VERTICAL_SIZE));
		myThread = new Thread(this);
		myThread.start();
		p = new Point2D.Double(0,0);
		p2 = new Point2D.Double(0,0);
		cent = new Point2D.Double(HORIZONTAL_SIZE/2,VERTICAL_SIZE/2);
		setColors();

	}// end constructor
	
	public void setColors(){
		c1 = new Color ((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random()));
		//c2 = new Color ((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random()));
		c2 = new Color (255-c1.getRed(), 255-c1.getGreen(), 255-c1.getBlue());
	}

	/**
	 * Implementation of <code>Runnable</code> which makes <code>Spr</code>
	 * animated.
	 */
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(10);// pause for 10 milliseconds
			} catch (InterruptedException e) {
				System.out.println("Thread ended.");
				System.exit(0);
			}// end catch
			getNextCoordinates();// recalculate position
		}// end while

	}// end run

	public void paint(Graphics g) {
		if (bgImage == null || bgImage.getWidth(null) != getWidth()
				|| bgImage.getHeight(null) != getHeight()) {
			bgImage = createImage(getWidth(), getHeight());
		}
		paintInBG(bgImage.getGraphics());
		g.drawImage(bgImage, 0, 0, null);

	}// end paint

	public void paintInBG(Graphics g) {
		//g.clearRect(0, 0, getWidth(), getHeight());
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(c1);
		g2.draw(new Rectangle2D.Double(p.x,p.y, 5, 5));
		g2.setColor(c2);
		g2.draw(new Rectangle2D.Double(p2.x,p2.y, 5, 5));
	}// end paintInBG

	/**
	 * Update the animation sequence.
	 */
	public void update(Graphics g) {
		paint(g);
	}// end update


	/**
	 * Process for calculating the next coordinates of the spiral to be drawn. 
	 */
	public static void getNextCoordinates() {
		if (count >=9000000){//superhuge
			//reset here
			count = 0;
		}else{
			if (count<10){
				speed +=0.01;
			} else {
				//speed = 1.3;
				speed+=.005;
			}
			
			p.setLocation(cent.x+loop*Math.sqrt(count*Math.PI/180)*Math.cos(count*Math.PI/180),
					cent.y+loop*Math.sqrt(count*Math.PI/180)*Math.sin(count*Math.PI/180));
			p2.setLocation(cent.x-loop*Math.sqrt(count*Math.PI/180)*Math.cos(count*Math.PI/180),
					cent.y-loop*Math.sqrt(count*Math.PI/180)*Math.sin(count*Math.PI/180));
			
		}
		count+=speed;
		//loop+=.15;
		System.out.println(count+"\tP1: ("+p.x+", "+p.y+")"+ "\tP2: ("+p2.x+", "+p2.y+")");
	}



}
