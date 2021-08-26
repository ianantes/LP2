public class implementaRect{
     public static void main (String[] args){
          Rect c = new Rect(60, 190, 80, 60);
          c.print();
     }
}
class Rect{
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
}
     void print(){
         System.out.format("O retangulo possui as coordenadas x e y iguais a %d e %d . E a largura e altura iguais a %d e %d", this.x, this.y,this.w, this.h);
     }
}
















