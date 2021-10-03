package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.event.*;

public class Ellipse extends Figure {
	
        public Ellipse (int x, int y, int w, int h, int r, int g, int b, int drawR, int drawG, int drawB) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.r = r;
			this.g = g;
			this.b = b;
			this.drawR = drawR;
			this.drawG = drawG;
			this.drawB = drawB;
	    }
	
		public void print() {
			System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
		}
		
		public void paint (Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(this.r, this.g, this.b));
			g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
			g2d.setColor(new Color(this.drawR, this.drawG, this.drawB));
			g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		}
}
