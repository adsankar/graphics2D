package pack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Basic animation of a circle making loops at random places.
 * @author Aleksander Sankar
 * @version 1.0
 * @since 1.0
 */
public class Go extends JPanel implements Runnable {

	
	/**
	 * Constants
	 */
	private final static int HORIZONTAL_SIZE = 800;
	private final static int VERTICAL_SIZE = 800;
	private final static int LOOP_SIZE = 100;
	private final static int SPEED = 2;
	
	/**
	 * Private Fields
	 */
	private static Thread myThread;
	private static Point2D.Double ref;
	private static Point2D.Double cent;
	private static int count = 0;
	private static Color newColor;
	private Image bgImage;

	/**
	 * Create a new <code>frame</code> and set its close operation to
	 * <code> EXIT_ON_CLOSE</code> so that the program terminates. Creates a
	 * <code> Go</code> object and places it in the frame, and shows it.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("A Ball Motion");// set the title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Go());
		frame.pack();
		frame.setVisible(true);// show the animation
	}// end main

	/**
	 * Constructor which sets the size of the frame, starts the thread and
	 * initializes the coordinates to (50,50).
	 */
	public Go() {
		this.setPreferredSize(new Dimension(HORIZONTAL_SIZE, VERTICAL_SIZE));
		myThread = new Thread(this);
		myThread.start();
		ref = new Point2D.Double(0,0);
		cent = new Point2D.Double(250,250);
		newColor = new Color (22,222,123);
	}// end constructor

	/**
	 * Draws a circle on the frame.
	 */
	public void paint(Graphics g) {
		if (bgImage == null || bgImage.getWidth(null) != getWidth()
				|| bgImage.getHeight(null) != getHeight()) {
			bgImage = createImage(getWidth(), getHeight());
		}
		paintInBG(bgImage.getGraphics());
		g.drawImage(bgImage, 0, 0, null);

	}// end paint

	/**
	 * Clears the frame, sets anti-aliasing on, and draws a circle.
	 * 
	 * @param g
	 */
	public void paintInBG(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4f, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(newColor);
		g2.draw(new Ellipse2D.Double(ref.x,ref.y, 50, 50));
		//g2.setColor(getBackground());
		//g2.fill(new Ellipse2D.Double(xC + 50, yC + 50, 100, 100));

	}// end paintInBG

	/**
	 * Update the animation sequence.
	 */
	public void update(Graphics g) {
		paint(g);
	}// end update

	/**
	 * Process for calculating the next coordinates of the circle to be drawn. 
	 */
	public static void getNextCoordinates() {

		count += SPEED;
		// if complete square path is made, go to another position
		if (count >=360) {

			//count = 0; // reset here

			cent.setLocation(Math.random() * HORIZONTAL_SIZE, Math.random() * VERTICAL_SIZE);
			newColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
			count = 0;
		}// end if
		else{
		ref.x = cent.x+LOOP_SIZE*Math.cos(count*Math.PI/180);
		ref.y=cent.y+LOOP_SIZE*Math.sin(count*Math.PI/180);
		}

	}// end getNextCoordinates

	/**
	 * Implementation of <code>Runnable</code> which makes <code>Go</code>
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

}// end class