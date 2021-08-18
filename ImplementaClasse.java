public class RectApp {
     public static void main (String[] args){
          Rect = new Rect(60, 190, 80, 60);
          r.print();
     }
}

class Rect{
     int x, y, w, h;
     Rect(int x, int y, int w,  int h){
           this.x = x;
           this.y = y;
           this.w = w;
           this.h = h;
     }
     void print(){
         System.out.format("O retangulo de tamanho (%d,%d) na posicao (%d,%d)\n ", 
                           this.w,this.h,this.x,this.y);
     }
}





























