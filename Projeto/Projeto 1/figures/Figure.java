package figures;

import java.awt.*;
import java.awt.event.*;



public abstract class Figure {
    int x, y;
    int r, g, b;
    int drawR, drawG, drawB;
    
    public void mudarCorContorno(int c1, int c2, int c3){
	    this.drawR = c1;
	    this.drawG = c2;
	    this.drawB = c3;
    }

    public void mudarCorFundo(int c1, int c2, int c3){
                this.r = c1;
		this.g = c2;
		this.b = c3;
    }	
    public abstract void paint (Graphics g);
}
