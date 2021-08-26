import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1, e2, e3;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(50,100, 100,30, Color.blue, Color.black);
	this.e2 = new Ellipse(50,200, 100,30, Color.yellow, Color.gray);
        this.e3 = new Ellipse(50,300, 100,30, Color.red, Color.pink);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
	this.e3.paint(g);
    }

}

class Ellipse {
    int x, y;
    int w, h;
    Color cf, cc;

    Ellipse (int x, int y, int w, int h, Color cf, Color cc) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.cf = cf;
	this.cc = cc;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.cc);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	g2d.setColor(this.cf);
	g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
