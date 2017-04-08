package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Advanced Pursuit Curves Program
 * @author Aleksander Sankar
 * Graphics Pd. 1
 */
public class SankarAdvTriangles extends Canvas{

	/**
	 * This program creates a frame, then draws pursuit curves on it, and displays it.
	 * @param args not used
	 */
	public static void main(String[] args) {
		// TODO comment

		//create the frame
		Frame myFrame = new Frame();
		myFrame.setSize(1024,768);//size the frame
		SankarAdvTriangles s = new SankarAdvTriangles();
		myFrame.add(s);//add the canvas to the frame
		myFrame.setBackground(new Color(0,0,0));//set background color to black
		myFrame.setVisible(true);//display the frame
		myFrame.setTitle("The Advanced Pursuit Curves");//set the title

		//terminates the program if the 'x' button is clicked
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//end windowClosing event
		});

	}//end main

	/**
	 * This method draws a pursuit octagon, square, and triangle, all with fading colors and fading transparencies.  
	 * @param Graphics g represents the picture drawn upon 
	 */
	public void paint(Graphics g){

		//set initial color to dark blue
		g.setColor(new Color(0,0,50,0));

		//define starting coordinates of the octagon
		int[] xpoints = {0,getWidth()/4,3*getWidth()/4,getWidth()-1,getWidth()-1,3*getWidth()/4, getWidth()/4,0};
		int[] ypoints = {getHeight()/4,0,0,getHeight()/4,3*getHeight()/4,getHeight(),getHeight(),3*getHeight()/4};

		//initialize float values for calculating the coordinates of each of the points
		//floats are used here to preserve accuracy and not offset the shapes due to rounding errors
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

		//determine the step size increment 
		float step = 0.955f;
		float step2 = 1-step;

		//draw a single octagon
		g.drawPolygon(xpoints, ypoints, 8);


		//loop through and draw the other octagons, recalculating each point, and fade color
		for (int i=0; i<25; i++){
			int fade =255*i/25;
			g.setColor(new Color(fade/20,fade,255-fade,50+fade/2));//set the new color

			//recalculations for the points
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

			//cast as ints and add to the array of coordinates
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
			g.drawPolygon(xpoints, ypoints, 8);//draw the octagon
		}//end pursuit octagon

		
		//initial points for pursuit square
		int[] xps = {256, 768, 768, 256};
		int[] yps = {192, 192, 576,576};
		nxa = xps[0];
		nya = yps[0];
		nxb = xps[1];
		nyb = yps[1];
		nxc = xps[2];
		nyc = yps[2];
		nxd = xps[3];
		nyd = yps[3];

		//set step size
		step = 0.97f;
		step2 = 1-step;

		//set color to blue
		g.setColor(new Color(0,255,0,0));
		g.drawPolygon(xps, yps, 4);

		//loop through and draw the other octagons, recalculating each point, and fade color
		for (int i=0; i<25; i++){	
			int fade = 255*i/25;
			g.setColor(new Color(255-fade,0,255-fade/2,fade));//set color

			//recalculate coordinates
			nxa = step*nxa+step2*nxb;
			nya = step*nya+step2*nyb;
			nxb = step*nxb+step2*nxc;
			nyb = step*nyb+step2*nyc;
			nxc = step*nxc+step2*nxd;
			nyc = step*nyc+step2*nyd;
			nxd = step*nxd+step2*nxa;
			nyd = step*nyd+step2*nya;

			//cast as ints and add them to the matrix of coordinates
			xps[0] = (int)(nxa);
			yps[0] = (int)(nya);
			xps[1] = (int)(nxb);
			yps[1] = (int)(nyb);
			xps[2] = (int)(nxc);
			yps[2] = (int)(nyc);
			xps[3] = (int)(nxd);
			yps[3] = (int)(nyd);
			g.drawPolygon(xps, yps, 4);
		}//end square
		
		//set color to orange
				g.setColor(new Color(255,255,0,0));

				//initialize coordinates points for the triangle 
				int[] xp = {412, 612, 512};
				int[] yp = {344+(int)(50*Math.sqrt(3)), 344+(int)(50*Math.sqrt(3)), 344-(int)(50*Math.sqrt(3))};
/*				int[] xp ={0,getWidth()/2,getWidth()};
				int[] yp = {getHeight()-100,-100,getHeight()-100};*/

				nxa = xp[0];
				nya = yp[0];
				nxb = xp[1];
				nyb = yp[1];
				nxc = xp[2];
				nyc = yp[2];
				g.drawPolygon(xp, yp, 3);//draw the triangle
				//set the step size
				step = 0.95f;
				step2 = 1-step;

				//loop through and draw the other triangles, recalculating each point, and fade color
				for (int j=0; j<25; j++){
					int fade = 255*j/25;
					g.setColor(new Color(255,255-fade,0,fade));//set color

					//recalculate coordinates
					nxa = step*nxa+step2*nxb;
					nya = step*nya+step2*nyb;
					nxb = step*nxb+step2*nxc;
					nyb = step*nyb+step2*nyc;
					nxc = step*nxc+step2*nxa;
					nyc = step*nyc+step2*nya;

					//cast as ints and add them to the matrix of coordinates
					xp[0] = (int)(nxa);
					yp[0] = (int)(nya);
					xp[1] = (int)(nxb);
					yp[1] = (int)(nyb);
					xp[2] = (int)(nxc);
					yp[2] = (int)(nyc);
					g.drawPolygon(xp, yp, 3);//draw the triangle

				}//end triangle

		
	}//end paint method
	
}//end class