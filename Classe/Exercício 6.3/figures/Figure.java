package figures;

import java.awt.Graphics;

public abstract class Figure {
    int x, y;
    int r, g, b;
    int drawR, drawG, drawB;
  
    public abstract void paint (Graphics g);
}
