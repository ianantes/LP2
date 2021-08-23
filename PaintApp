import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, Color.red, Color.black);
	this.r2 = new Rect(50,150, 100,30, Color.blue, Color.green);
	this.r3 = new Rect(50,250, 100,30, Color.pink, Color.gray);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
	this.r2.paint(g);
	this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color rf, rc;

    Rect (int x, int y, int w, int h, Color rf, Color rc) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.rf = rf; // cor de fundo
	this.rc = rc; // cor do contorno
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.rc);
        g2d.drawRect(this.x,this.y, this.w,this.h); // desenha o contorno do retangulo
        g2d.setColor(this.rf);
	g2d.fillRect(this.x,this.y, this.w,this.h); // preenche o retangulo
    }
}
