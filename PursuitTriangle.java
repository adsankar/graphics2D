package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class PursuitTriangle extends Canvas {

	public void paint(Graphics g){
		//g.setColor(Color.black);
	//	g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(150,0,255));
		double x = getWidth();
		double y = getHeight();
		int centx = (int) x/2;
		int centy = (int) y/2;
		int a = 0, b = 0, h = 0;
		if(x / 2.0 * Math.sqrt(3) < y) {
			a = 0;
			b = (int) x;
			h = (int) (x / 2.0 * Math.sqrt(3));
		}
		else {
			h = (int) y;
			a = (int) (centx + y / Math.sqrt(3));
			b = (int) (centx - y / Math.sqrt(3));
		}
		int[] xpoints = {a, b, centx};
		int[] ypoints = {centy - h/2, centy - h/2, centy + h/2};
		float nxa = xpoints[0];
		float nya = ypoints[0];
		float nxb = xpoints[1];
		float nyb = ypoints[1];
		float nxc = xpoints[2];
		float nyc = ypoints[2];
		float step = 0.98f;
		float step2 = 1-step;
		for (int i=0; i<60; i++){
			int fade = 255*i/60;
			Color r= new Color(255-fade,0,fade);
			g.setColor(r);
			nxa = step*nxa+step2*nxb;
			nya = step*nya+step2*nyb;
			nxb = step*nxb+step2*nxc;
			nyb = step*nyb+step2*nyc;
			nxc = step*nxc+step2*nxa;
			nyc = step*nyc+step2*nya;
			xpoints[0] = (int)(nxa);
			ypoints[0] = (int)(nya);
			xpoints[1] = (int)(nxb);
			ypoints[1] = (int)(nyb);
			xpoints[2] = (int)(nxc);
			ypoints[2] = (int)(nyc);
			g.drawPolygon(xpoints, ypoints, 3);


		}
	}
}
