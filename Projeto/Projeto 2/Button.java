import ivisible.IVisible;
import figures.Figure;
import java.awt.*;

public class Button implements IVisible {
	    int idx;
		private Figure fig;
		
		protected Button(int idx, Figure fig) {
		   this.idx = idx;
		   this.fig = fig;
		   this.fig.x = 4+20;
	       this.fig.y = 4+20+idx*40;
	       this.fig.w = 40-4*2;
	       this.fig.h = 40-4*2; 
		}
        
		public boolean clicked(int x, int y){
		    return((20 <= x && x <= (20+40)) && (20+this.idx*40 <= y && y <= (20+this.idx*40+40)));
		}
		
		
		public void paint(Graphics g, boolean focused) {
			    Graphics g2d = (Graphics2D) g;
		        
				if(focused) {
                    g2d.setColor(Color.gray);
			    }
                else {
                    g2d.setColor(Color.lightGray);
			    }
            
			    g2d.fillRect(20,20+this.idx*40,40,40);
			    g2d.setColor(Color.black);		
                g2d.drawRect(20,20+this.idx*40,40,40);
                this.fig.paint(g, false);			
		}
}