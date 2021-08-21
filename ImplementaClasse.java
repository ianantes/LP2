import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
     public static void main (String[] args){
        Hello2DFrame frame = new Hello2DFrame();
        frame.getContentPane().setBackground(Color.green);
        frame.setVisible(true);
          
          Rect = new Rect(60, 190, 80, 60);
          int a = r1.area();
          System.out.format("Area = %d\n", a);
          r1.drag(10,20);
          a = r1.area();
          System.out.format("Valor da area apos a execucao da funcao drag = %d\n", a);
          r.print();
          
     }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

class Rect{
      int x, y, w, h;
     Rect(int x, int y, int w,  int h){
           this.x = x;
           this.y = y;
           this.w = w;
           this.h = h;     
     }
      int area(){
          return this.x * this.y;
      }
     
     public void drag (int dx, int dy){
          this.x += dx;
          this.y += dy;
     }
     
}
      
    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        g2d.drawRect(0,0,50,100);
        g2d.drawOval(50,40,700,700);
    }
}
   
     void print(){
         System.out.format("O retangulo de tamanho (%d,%d) na posicao (%d,%d)\n ", 
                           this.w,this.h,this.x,this.y);
     }
}





























