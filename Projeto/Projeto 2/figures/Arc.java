package figures;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;

public class Arc extends Figure {
	int start, extent, type;
	
	public Arc (int x, int y, int w, int h, int start, int extent, int type, int r, int g, int b, int drawR, int drawG, int drawB) {
	    super(x, y, w, h, r, g, b, drawR, drawG, drawB);
		this.start = start;
		this.extent = extent;
		this.type = type;
	}
	
	private void print() {
	    System.out.format("Arco de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
	}
	
	public void paint (Graphics g, boolean focused) {
	    Graphics2D g2d = (Graphics2D) g;
		
		if(focused) {
		   g2d.setColor(Color.red);
		   g2d.draw(new Arc2D.Double(this.x-2, this.y-2, this.w+4, this.h+4, this.start, this.extent, Arc2D.CHORD));
		}
		
		g2d.setColor(new Color(this.r, this.g, this.b));
		g2d.fill(new Arc2D.Double(this.x, this.y, this.w, this.h, this.start, this.extent, this.type));
		g2d.setColor(new Color(this.drawR, this.drawG, this.drawB));
        g2d.draw(new Arc2D.Double(this.x, this.y, this.w, this.h, this.start, this.extent, this.type));		
	}
}
