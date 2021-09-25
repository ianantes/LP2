import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
		                int ctrlx1 = rand.nextInt(350);
		                int ctrly1 = rand.nextInt(350);
		                int x2 = rand.nextInt(350);
		                int y2 = rand.nextInt(350);
		                int ctrlx2 = rand.nextInt(350);
		                int ctrly2 = rand.nextInt(350);
		                int r = rand.nextInt(256);
		                int g = rand.nextInt(256);
		                int b = rand.nextInt(256);
		                int drawR = rand.nextInt(256);
		                int drawG = rand.nextInt(256);
		                int drawB = rand.nextInt(256);
                    if (evt.getKeyChar() == 'r') {
                        Rect r1 = new Rect(x,y, w, h, r, g, b, drawR, drawG, drawB);
                        figs.add(r1);
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w, h, r, g, b, drawR, drawG, drawB));
                    } else if (evt.getKeyChar() == 'c') {
			                  figs.add(new CubicCurve(x, y, ctrlx1, ctrly1, x2, y2, ctrlx2, ctrly2, r, g, b, drawR, drawG, drawB));
		    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
