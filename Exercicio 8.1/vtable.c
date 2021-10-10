#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int (* Figure_Area) (struct Figure*);
typedef int (* Figure_Perimetro) (struct Figure*);

typedef struct{
    void (* print) (struct Figure*);
    int (* area) (struct Figure*);
    int (* perimetro) (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) com area %d e perimetro %d.\n\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int rect_area (Rect* this) {
	Figure* sup = (Figure*) this;
	return this->w * this->h;
}

int rect_perimetro (Rect* this) {
	Figure* sup = (Figure*) this;
	return sup->x + sup->x + sup->y + sup->y;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area) rect_area,
    (Figure_Perimetro) rect_perimetro
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) com area %d e perimetro %d.\n\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int ellipse_area (Ellipse* this) {
	Figure* sup = (Figure*) this;
	return this->w * this->h;
}

int ellipse_perimetro (Ellipse* this) {
	Figure* sup = (Figure*) this;
	return sup->x + sup->x + sup->y + sup->y;
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area) ellipse_area,
    (Figure_Perimetro) ellipse_perimetro
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////
/Figura Arco/
typedef struct {
    Figure super;
    int w, h, start, extent, type;
} Arc;

void arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) na posicao (%d,%d).\nSeu angulo inicial e sua extensao angular estao em (%d,%d) graus.\nSeu tipo e %d. Sua area e %d. Seu perimetro e %d.\n\n",
           this->w, this->h, sup->x, sup->y, this->start, this->extent, this->type, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int arc_area (Arc* this) {
	Figure* sup = (Figure*) this;
	return this->w * this->h;
}

int arc_perimetro (Arc* this) {
	Figure* sup = (Figure*) this;
	return sup->x + sup->x + sup->y + sup->y;
}

Figure_vtable arc_vtable = {
    (Figure_Print) arc_print,
    (Figure_Area) arc_area,
    (Figure_Perimetro) arc_perimetro
};

Arc* arc_new (int x, int y, int w, int h, int start, int extent, int type) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->vtable = &arc_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->start = start; 
    this->extent = extent; 
    this->type = type;
}

///////////////////////////////////////////////////////////////////////////////
/Figura Oval/
typedef struct {
    Figure super;
    int w, h;
} Oval;

void oval_print (Oval* this) {
    Figure* sup = (Figure*) this;
    printf("Oval com tamanho (%d,%d) na posicao (%d,%d) com area %d e perimetro %d.\n\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int oval_area (Oval* this) {
	Figure* sup = (Figure*) this;
	return this->w * this->h;
}

int oval_perimetro (Oval* this) {
	Figure* sup = (Figure*) this;
	return sup->x + sup->x + sup->y + sup->y;
}

Figure_vtable oval_vtable = {
    (Figure_Print) oval_print,
    (Figure_Area) oval_area,
    (Figure_Perimetro) oval_perimetro
};

Oval* oval_new (int x, int y, int w, int h) {
    Oval*   this  = malloc(sizeof(Oval));
    Figure* sup = (Figure*) this;
    sup->vtable = &oval_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

int main () {
    Figure* figs[8] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) arc_new(210,110,305,130,90,270,3), // se o tipo for 3, é um arco PIE
        (Figure*) oval_new(20,20,40,40),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) arc_new(210,110,305,130,125,210,1), // se o tipo for 1, é um arco CHORD
        (Figure*) oval_new(10,10,50,50),
    };

    ///
    int i;
    for (i=0; i<8; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (i=0; i<8; i++) {
        free(figs[i]);
    }
    return 0;
}
