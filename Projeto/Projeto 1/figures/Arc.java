package figures;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;
import java.awt.event.*;

public class Arc extends Figure {
	int start, extent, type;
	
	public Arc (int x, int y, int w, int h, int start, int extent, int type, int r, int g, int b, int drawR, int drawG, int drawB) {
	        this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.start = start;
		this.extent = extent;
		this.type = type;
		this.r = r;
		this.g = g;
		this.b = b;
		this.drawR = drawR;
		this.drawG = drawG;
		this.drawB = drawB;
	}
	
	public void print() {
	    System.out.format("Arco de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
	}
	
	public void paint (Graphics g) {
	        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.r, this.g, this.b));
		g2d.fill(new Arc2D.Double(this.x, this.y, this.w, this.h, this.start, this.extent, this.type));
		g2d.setColor(new Color(this.drawR, this.drawG, this.drawB));
                g2d.draw(new Arc2D.Double(this.x, this.y, this.w, this.h, this.start, this.extent, this.type));		
	}
}
