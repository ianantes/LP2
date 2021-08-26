#include <stdio.h>
#include <stdlib.h> 

/* questão 1 */
typedef struct {
  int x , y;
  

} Circle;

/* questão 2 */
void print (Circle *r){
    printf("O circulo possui raio x e y iguais a %d e %d , r->x, r->y);
}

int main(){
    Circle c(27.5, 33.6);
    print(&c);
}
