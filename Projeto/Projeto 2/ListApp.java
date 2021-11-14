import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
	ArrayList<Button> buts = new ArrayList<Button>();
	Figure focus = null;
	Button but_focus = null;
	int ind;
    Random rand = new Random();

    ListFrame () {
		// Leitura do arquivo proj.bin
		try {   
		     FileInputStream f = new FileInputStream("proj.bin");
		     ObjectInputStream o = new ObjectInputStream(f);
		     this.figs = (ArrayList<Figure>) o.readObject();
		     o.close();
	    } catch(Exception x) {
		     System.out.println("ERRO!");
	    }
		
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
					// Escrita no arquivo proj.bin
					try {    
					     FileOutputStream f = new FileOutputStream("proj.bin");
					     ObjectOutputStream o = new ObjectOutputStream(f);
					     o.writeObject(figs);
					     o.flush();
					     o.close();
				    } catch (Exception x) {
				    }	
                    System.exit(0);
                }
            }
        );
		
		setFocusTraversalKeysEnabled(false);
		
	    buts.add(new Button(1, new Rect(0,0,0,0,0,0,0,0,0,0)));
	    buts.add(new Button(2, new Ellipse(0,0,0,0,0,0,0,0,0,0)));
	    buts.add(new Button(3, new Arc(0,0,0,0,180,250,0,0,0,0,0,0,0)));
	    buts.add(new Button(4, new Oval(0,0,0,0,0,0,0,0,0,0)));
		
		this.addMouseListener (
		    new MouseAdapter() {
			    public void mousePressed (MouseEvent evt) { 
				   Point pos = new Point(getMousePosition());
                   focus = null; 
                   but_focus = null;				   
				   for (Figure fig: figs){
				        if(fig.clicked(pos.x, pos.y)) {
							focus = fig;
							figs.remove(fig);
							figs.add(fig);
							repaint();
							break;
                        }
                        else
                        {
                            focus = null;
                            repaint();
                        }					
				    }
					
					for (Button but: buts) {
		                if (but.clicked(pos.x,pos.y)) {
			                but_focus = but;
			                repaint();
			                break;
			            }
		            }
					
					// Quando um dos botões ganha foco, é guardado o índice para saber qual a figura referente ao botão clicado
				    if (but_focus != null) {
						if (but_focus.idx == 1) {
							ind = 1;
						} 
						else if (but_focus.idx == 2) {
						    ind = 2;
						}
						else if (but_focus.idx == 3) {
							ind = 3;
						}
						else if (but_focus.idx == 4) {
							ind = 4;
						}
						repaint();
				     }
				    // Quando está sem foco o botão e a figura, é feito, clicando no mouse, a figura referente ao último botão clicado
				    if ((but_focus == null) && (focus == null)) {
						if (ind == 1) {
							figs.add(new Rect(pos.x,pos.y, rand.nextInt(50),rand.nextInt(50),0,0,0,0,0,0));
							ind = 0;
						} 
						else if (ind == 2) {
							figs.add(new Ellipse(pos.x,pos.y, rand.nextInt(50),rand.nextInt(50),0,0,0,0,0,0));
							ind = 0;
						}
						else if (ind == 3) {
							figs.add(new Arc(pos.x,pos.y, rand.nextInt(50),rand.nextInt(50), rand.nextInt(280),rand.nextInt(280), rand.nextInt(3),0,0,0,0,0,0));
							ind = 0;
						}
						else if (ind == 4) {
							figs.add(new Oval(pos.x,pos.y, rand.nextInt(50),rand.nextInt(50),0,0,0,0,0,0));
							ind = 0;
						}
						repaint();
				    }
				}
			}
		);
		
		this.addMouseMotionListener (
		    new MouseMotionAdapter() {
			    public void mouseDragged (MouseEvent evt) {         
				    Point pos = new Point(getMousePosition()); 
                    if (focus != null){
                       focus.move(pos.x-focus.x, pos.y-focus.y);
					   repaint();
					}					
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
                        figs.add(new Rect(pos.x, pos.y, w,h, r, g, b, drawR, drawG, drawB));
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(pos.x, pos.y, w,h, r, g, b, drawR, drawG, drawB));
                    } else if (evt.getKeyChar() == 'o') {
					    figs.add(new Oval(pos.x, pos.y, w, h, r, g, b, drawR, drawG, drawB));
					} else if (evt.getKeyChar() == 'a') {
					    figs.add(new Arc(pos.x, pos.y, w, h, start, extent, type, r, g, b, drawR, drawG, drawB));
					// Deletar a figura focada
					} else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
                            figs.remove(focus);
                            focus = null;
							repaint();
                    // Movimento das figuras através dos teclados UP, DOWN, LEFT, RIGHT
					} else if(evt.getKeyCode() == KeyEvent.VK_UP){
				                if(focus != null){
                                   focus.move(0,-1);								   
					            }								 
					} else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
					            if(focus != null){
                                   focus.move(0,1);
								}
					} else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
					            if(focus != null){
                                   focus.move(-1,0);
								}
					} else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
					            if(focus != null){
                                   focus.move(1,0);
								}
					// Aumentar e diminuir de tamanho a figura focada
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
					// Mudar a cor de fundo
                    } else if(evt.getKeyChar() == 'f'){
					        if(focus!=null){
							   focus.cf(r,g,b); // cor aleatória
							}	
					// Mudar a cor de contorno
                    } else if(evt.getKeyChar() == 'c'){
					        if(focus!=null){
							   focus.cc(drawR,drawG,drawB);  // cor aleatória
							}
                    // Mudança de foco da figura							
                    } else if(evt.getKeyCode() == KeyEvent.VK_TAB){
				            for (Figure fig: figs) {
					           if (focus != fig) {
					              focus = fig;
					              figs.remove(fig);
					              figs.add(fig);
					              break;
					            }
				            }    
			        }										
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(500, 500);
    }

    public void paint (Graphics g) {
        super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
        for (Figure fig: this.figs) {
            fig.paint(g, false);
        }
		
		if(focus != null){
		    focus.paint(g, true);
		}
		
		for(Button but: this.buts) {
	        but.paint(g, but == but_focus);
	    }
    }
}
