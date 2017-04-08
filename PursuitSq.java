package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class PursuitSq extends Canvas{

	public void paint(Graphics g){
		int[] xpoints = {0, getWidth(), getWidth(),0};
		int[] ypoints = {0, 0, getHeight(),getHeight()};
		float nxa = xpoints[0];
		float nya = ypoints[0];
		float nxb = xpoints[1];
		float nyb = ypoints[1];
		float nxc = xpoints[2];
		float nyc = ypoints[2];
		float nxd = xpoints[3];
		float nyd = ypoints[3];
		float step = 0.98f;
		float step2 = 1-step;
		g.drawPolygon(xpoints, ypoints, 4);
		for (int i=0; i<120; i++){
			int fade = 255*i/120;
			Color r= new Color(fade,255-fade,fade/2);
			g.setColor(r);
			nxa = step*nxa+step2*nxb;
			nya = step*nya+step2*nyb;
			nxb = step*nxb+step2*nxc;
			nyb = step*nyb+step2*nyc;
			nxc = step*nxc+step2*nxd;
			nyc = step*nyc+step2*nyd;
			nxd = step*nxd+step2*nxa;
			nyd = step*nyd+step2*nya;
			
			xpoints[0] = (int)(nxa);
			ypoints[0] = (int)(nya);
			xpoints[1] = (int)(nxb);
			ypoints[1] = (int)(nyb);
			xpoints[2] = (int)(nxc);
			ypoints[2] = (int)(nyc);
			xpoints[3] = (int)(nxd);
			ypoints[3] = (int)(nyd);
			g.drawPolygon(xpoints, ypoints, 4);
		}
	}

}
