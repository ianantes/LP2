#include <stdio.h>
#include <stdlib.h> 

/* questão 1 */
typedef struct {
  int x , y;
  int w , h;

} Rect;

/* questão 2 */
void print (Rect *r){
    printf("O retangulo possui as coordenadas x e y iguais a %d e %d . E a largura e altura iguais a %d e %d", r->x, r->y, r->w, r->h);
}

int main(){
   Rect r = {60, 190, 80, 60};
   print(&r);
}
