package graphics;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class AnimatedOct extends Canvas implements Runnable{

	private static int MAX_OCT = 300;
	private static int start = 00;
	
	private static final float STEP_SIZE =0.93f;
	private Thread repainter;
	private Image bgImage =null;
	private BufferedImage bi= null;
	private int xc;
	private int yc;
	private boolean isClicked;
	private boolean set;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Frame myFrame = new Frame();
		myFrame.setBackground(Color.black);
		AnimatedOct o = new AnimatedOct();
		myFrame.add(o);
		myFrame.setSize(800,800);
		myFrame.setTitle("This is a pursuit octagon:");
		myFrame.setVisible(true);
		myFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public AnimatedOct(){
		repainter = new Thread(this);
		repainter.start();
		MouseMotionListener m = new MouseMotionListener() {
			//int i=1;
			
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				isClicked =true;
				xc = e.getX();
				yc = e.getY();
			}

			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		this.addMouseMotionListener(m);
		MouseListener m2 = new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				set = true;
			}
		};
		this.addMouseListener(m2);
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	
	public void paint(Graphics g){
		if (bgImage==null || bgImage.getWidth(null)!=getWidth() || bgImage.getHeight(null)!= getHeight()){
			bgImage = createImage(getWidth(),getHeight());
		}
			paintInBG(bgImage.getGraphics());
			g.drawImage(bgImage,0,0,null);

	}
	
	public void run(){
		while (!false){
			repaint();
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e){
				System.out.println("Thread ended.");
				System.exit(0);
			}
			if (start< MAX_OCT) start++;
 		}
	}

	public void paintInBG(Graphics g2){ 
		Graphics2D g = (Graphics2D)g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setStroke(new BasicStroke(1.8f));
		//g.clearRect(0, 0, getWidth(), getHeight());
		
		//remove comments for trippy effects
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(100,0,255));
		//g.setColor(new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random())));
		int[] xpoints = {0,getWidth()/4,3*getWidth()/4,getWidth()-1,getWidth()-1,3*getWidth()/4, getWidth()/4,0};
		int[] ypoints = {getHeight()/4,0,0,getHeight()/4,3*getHeight()/4,getHeight(),getHeight(),3*getHeight()/4};
		float nxa = xpoints[0];
		float nya = ypoints[0];
		float nxb = xpoints[1];
		float nyb = ypoints[1];
		float nxc = xpoints[2];
		float nyc = ypoints[2];
		float nxd = xpoints[3];
		float nyd = ypoints[3];
		float nxe = xpoints[4];
		float nye = ypoints[4];
		float nxf = xpoints[5];
		float nyf = ypoints[5];
		float nxg = xpoints[6];
		float nyg = ypoints[6];
		float nxh = xpoints[7];
		float nyh = ypoints[7];
		float step = STEP_SIZE;
		float step2 = 1-step;
		g.drawPolygon(xpoints, ypoints, 8);
		int i;
		for (i=0; i<start; i++){
			nxa = step*nxa+step2*nxb;
			nya = step*nya+step2*nyb;
			nxb = step*nxb+step2*nxc;
			nyb = step*nyb+step2*nyc;
			nxc = step*nxc+step2*nxd;
			nyc = step*nyc+step2*nyd;
			nxd = step*nxd+step2*nxe;
			nyd = step*nyd+step2*nye;
			nxe = step*nxe+step2*nxf;
			nye = step*nye+step2*nyf;
			nxf = step*nxf+step2*nxg;
			nyf = step*nyf+step2*nyg;
			nxg = step*nxg+step2*nxh;
			nyg = step*nyg+step2*nyh;
			nxh = step*nxh+step2*nxa;
			nyh = step*nyh+step2*nya;
			
			xpoints[0] = (int)(nxa);
			ypoints[0] = (int)(nya);
			xpoints[1] = (int)(nxb);
			ypoints[1] = (int)(nyb);
			xpoints[2] = (int)(nxc);
			ypoints[2] = (int)(nyc);
			xpoints[3] = (int)(nxd);
			ypoints[3] = (int)(nyd);
			xpoints[4] = (int)(nxe);
			ypoints[4] = (int)(nye);
			xpoints[5] = (int)(nxf);
			ypoints[5] = (int)(nyf);
			xpoints[6] = (int)(nxg);
			ypoints[6] = (int)(nyg);
			xpoints[7] = (int)(nxh);
			ypoints[7] = (int)(nyh);
			g.drawPolygon(xpoints, ypoints, 8);
			//g.setColor(new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random())));
		}
		Graphics2D g3 = (Graphics2D)g;
		bi = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
		g3 = (Graphics2D)(bi.getGraphics());
		Ellipse2D.Double e = new Ellipse2D.Double(360,360,60,60);
		g3.setColor(new Color(50,0,255));
		g3.fill(e);
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.CLEAR,  .4f);
		g3.setComposite(ac);
		
		int[] x = {370,400,370};
		int []y = {370,370,400};
		g3.setPaint(getBackground());
		g3.fill(new Polygon(x, y, 3));
		if (isClicked){
			g.setColor(Color.black);
			g.fillOval(xc-50, yc-50, 100, 100);
		}
		if (set){
			g.setColor(Color.black);
			g.fillOval(xc-50, yc-50, 100, 100);
		}
		g.drawImage(bi,0,0,null);
	}

}
