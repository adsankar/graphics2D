package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas {
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.CYAN);
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
		g.drawPolygon(xpoints, ypoints, 3);
	}
}
