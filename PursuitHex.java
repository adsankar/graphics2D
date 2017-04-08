package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class PursuitHex extends Canvas {

	public void paint(Graphics g){
		int[] xpoints = {0, getWidth()/4, 3*getWidth()/4,getWidth(),3*getWidth()/4,getWidth()/4};
		int[] ypoints = {getHeight()/2, 1, 1,getHeight()/2,getHeight()-1,getHeight()};
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
		float step = 0.96f;
		float step2 = 1-step;
		g.drawPolygon(xpoints, ypoints, 6);
		for (int i=0; i<120; i++){
			int fade = 255*i/120;
			Color r= new Color(0,255-fade,fade);
			g.setColor(r);
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
			nxf = step*nxf+step2*nxa;
			nyf = step*nyf+step2*nya;
			
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
			g.drawPolygon(xpoints, ypoints, 6);
		}
	}
	
}
