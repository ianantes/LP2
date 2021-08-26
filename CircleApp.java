public class CircleApp {
     public static void main (String[] args){
          Circle c = new Circle(27.5, 33.6);
          c.print();
     }
}

class Circle{
     double rx, ry;
     Circle(double rx, double ry){
           this.rx = rx;
           this.ry = ry;
     }
     void print(){
         System.out.format("O circulo tem a medida do raio vertical igual a %.2f e possui a medida do raio horizontal igual a %.2f", this.ry, this.rx);
     }
}
