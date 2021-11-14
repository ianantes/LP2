package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
	
                public Ellipse (int x, int y, int w, int h, int r, int g, int b, int drawR, int drawG, int drawB) {
			super(x, y, w, h, r, g, b, drawR, drawG, drawB);
	        }
	
		private void print() {
			System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
		}
		
		public void paint (Graphics g, boolean focused) {
			Graphics2D g2d = (Graphics2D) g;
			
			if(focused) {
		            g2d.setColor(Color.red);
		            g2d.draw(new Ellipse2D.Double(this.x-2, this.y-2, this.w+4, this.h+4));
		        }
			
			g2d.setColor(new Color(this.r, this.g, this.b));
			g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
			g2d.setColor(new Color(this.drawR, this.drawG, this.drawB));
			g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		}
}
