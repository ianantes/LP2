import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
     public static void main (String[] args) {
          Rect r1 = new Rect(50,25);
          int a = r1.area();
          System.out.format("Area = %d\n", a);
          r1.drag(10,20);
          a = r1.area();
          System.out.format("Valor da area apos a execucao da funcao drag = %d\n", a);
     }
}

class Rect{
      int x, y;
     Rect(int x, int y){
           this.x = x;
           this.y = y;
               
     }
      int area(){
          return this.x * this.y;
      }
     
     void drag(int dx, int dy){
	    this.x += dx;
         this.y += dy;
	    System.out.format("Valor de x atual = %d\nValor de y atual = %d\n", this.x, this.y);
























