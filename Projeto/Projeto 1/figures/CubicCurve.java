package figures;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.CubicCurve2D.Double;

public class CubicCurve extends Figure {
	int ctrlx1, ctrly1;
	int x2, y2;
	int ctrlx2, ctrly2;
	
	public CubicCurve (int x, int y, int ctrlx1, int ctrly1, int x2, int y2, int ctrlx2, int ctrly2, int r, int g, int b, int drawR, int drawG, int drawB) {
	        this.x = x;
		      this.y = y;
		      this.ctrlx1 = ctrlx1;
		      this.ctrly1 = ctrly1;
		      this.x2 = x2;
		      this.y2 = y2;
		      this.ctrlx2 = ctrlx2;
		      this.ctrly2 = ctrly2;
		      this.r = r;
		      this.g = g;
		      this.b = b;
		      this.drawR = drawR;
		      this.drawG = drawG;
		      this.drawB = drawB;
	}
	
	public void print() {
	    System.out.format("Curva cubica nas coordenadas inciais (%d,%d) e finais (%d,%d). Primeiros pontos de controle (%d,%d) e segundos pontos de controle (%d,%d)\n", 
			this.x, this.y, this.x2, this.y2, this.ctrlx1, this.ctrly1, this.ctrlx2, this.ctrly2);
	}
	
	public void paint (Graphics g) {
	   Graphics2D g2d = (Graphics2D) g;
	   g2d.setColor(new Color(this.r, this.g, this.b));
	   g2d.fill(new CubicCurve2D.Double(this.x, this.y, this.ctrlx1, this.ctrly1, this.x2, this.y2, this.ctrlx2, this.ctrly2));
	   g2d.setColor(new Color(this.drawR, this.drawG, this.drawB));
     g2d.draw(new CubicCurve2D.Double(this.x, this.y, this.ctrlx1, this.ctrly1, this.x2, this.y2, this.ctrlx2, this.ctrly2));		
	}
}
