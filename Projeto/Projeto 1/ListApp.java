import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

         this.addKeyListener (
                 new KeyAdapter() {
                                    public void keyPressed (KeyEvent evt) {
                                        Point pos = new Point(getMousePosition());
                                        int w = rand.nextInt(50);
                                        int h = rand.nextInt(50);
					int r = rand.nextInt(256);
				        int g = rand.nextInt(256);
				        int b = rand.nextInt(256);
				        int drawR = rand.nextInt(256);
				        int drawG = rand.nextInt(256);
				        int drawB = rand.nextInt(256);
					int start = rand.nextInt(350);
					int extent = rand.nextInt(350);
					int type = rand.nextInt(3);
					// Criação das figuras
					if (evt.getKeyChar() == 'r') {
					       Rect r1 = new Rect(pos.x, pos.y, w,h, r, g, b, drawR, drawG, drawB);
					       figs.add(r1);
				        } else if (evt.getKeyChar() == 'e') {
						figs.add(new Ellipse(pos.x, pos.y, w,h, r, g, b, drawR, drawG, drawB));
					} else if (evt.getKeyChar() == 'o') {
					        figs.add(new Oval(pos.x, pos.y, w, h, r, g, b, drawR, drawG, drawB));
					} else if (evt.getKeyChar() == 'a') {
					        figs.add(new Arc(pos.x, pos.y, w, h, start, extent, type, r, g, b, drawR, drawG, drawB));
					// Deletar a figura que estiver focada
					} else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
                                               figs.remove(focus);
                                               focus = null;
					       repaint();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                       // Movimento das figuras através dos teclados UP, DOWN, LEFT, RIGHT
					} else if(evt.getKeyCode() == KeyEvent.VK_UP){
				                if(focus != null){
                                                        focus.mover(0,-1);								   
					        }								 
					} else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
					            if(focus != null){
                                                         focus.mover(0,1);
						    }
					} else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
					            if(focus != null){
                                                         focus.mover(-1,0);
						    }
					} else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
					            if(focus != null){
                                                         focus.mover(1,0);
					}
					// Redimensionamento da figura focada (aumentar e diminuir de tamanho)
					} else if(evt.getKeyChar() == '+'){
					        for (Figure fig: figs){
				                    if(focus == fig){
                                                       fig.zoom(1,1);							   
					            }
				                }
					
					} else if(evt.getKeyChar() == '-'){
					        for (Figure fig: figs){
				                   if(focus == fig){
                                                       fig.zoom(-1,-1);								   
					           }
				                }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////						
					// Mudar as cores de fundo
					} else if(evt.getKeyChar() == '1'){
					        if(focus!=null){
							focus.mudarCorFundo(255,0,0);  // vermelho
						}	
					} else if(evt.getKeyChar() == '2'){
					        if(focus!=null){
							 focus.mudarCorFundo(0,255,0);  // verde
						}
                                        } else if(evt.getKeyChar() == '3'){
					        if(focus!=null){
							  focus.mudarCorFundo(0,0,255);  // azul
						}	
                                        } else if(evt.getKeyChar() == '4'){
					        if(focus!=null){
							   focus.mudarCorFundo(255,255,0); // amarelo
						}	
					// Mudar as cores de contorno
                                        } else if(evt.getKeyChar() == '5'){
					        if(focus!=null){
							   focus.mudarCorContorno(255,0,0);  // vermelho
						}	
					} else if(evt.getKeyChar() == '6'){
					        if(focus!=null){
							   focus.mudarCorContorno(0,255,0);  // verde
						}
                                        } else if(evt.getKeyChar() == '7'){
					        if(focus!=null){
							   focus.mudarCorContorno(0,0,255);  // azul
						}	
                                        } else if(evt.getKeyChar() == '8'){
					        if(focus!=null){
							   focus.mudarCorContorno(255,255,0);  // amarelo
					        }	
                                        }								
                                        repaint();
                                  }
                 }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
