package figures;

import java.io.Serializable;
import ivisible.IVisible;



public abstract class Figure implements IVisible, Serializable {
    public int x, y, w, h;
    public int r, g, b;
    public int drawR, drawG, drawB;
	
    public Figure(int x, int y, int w, int h, int r, int g, int b, int drawR, int drawG, int drawB){
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
    
    public void cc(int c1, int c2, int c3){
	    this.drawR = c1;
	    this.drawG = c2;
	    this.drawB = c3;
    }

    public void cf(int c1, int c2, int c3){
                this.r = c1;
		this.g = c2;
		this.b = c3;
    }

     public void zoom (int dw, int dh){
	    this.w += dw;
	    this.h += dh;
		
    }
	
    public void move (int dx, int dy){
	    this.x += dx;
	    this.y += dy;
		
    }	
    public boolean clicked (int x, int y) {
	    return((this.x <= x && x <= (this.w + this.x)) && (this.y <= y && y <= (this.y + this.h)));
    }
}
