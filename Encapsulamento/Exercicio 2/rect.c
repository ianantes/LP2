#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

typedef struct Rect {
	int x, y, w, h;
}Rect;

Rect* rect_new (void) {
    Rect* this  = malloc(sizeof(Rect));
    this->x = 10;
    this->y = 20;
    this->w = 0;
    this->h = 0;	
}

void rect_drag(Rect* this, int dx, int dy) {
	this->x += dx;
	this->y += dy;
}

void rect_print(Rect* this) {
    printf("RECT (%d,%d) (%d,%d).\n\n",this->w, this->h, this->x, this->y);
}
