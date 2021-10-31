// Classe abstrata

   // a) Cenário representativo
   
    /*          Classe D&D
	          /      |     \            Todas as subclasses citadas apresentam características em comum como, por exemplo, poder, força, ataque e outros.
	         /       |      \
		      /        |       \
	   barbaro  feiticeito  Ladino
		
	*/
	
	/* b) Usei esse exemplo como caso de uso para a classe abstrata pois, ao construir um personagem de D&D, há um conjunto de classes fora 
              esses que apresentei no cenário representativo que o jogador pode escolher para fazer o personagem. Com isso, foquei nisso como 
	      uma superclasse e as classes dos personagens foquei como subclasses. E em cada classe, apresenta características em comum como
              força, ataque, poder e outros. */

       // c) Esboço do código

             public class abstract ClassD&D {
                int force, attack;
                String power;

                public ClasseD&D(int force, int attack, String power){			
	                        this.force = force;
				this.attack = attack;
				this.power = power;
		}
             }


// Interface

   // a) Cenário representativo
   
        // Objetos pensados: armário e um copo de geleia

    /*   "Abrível":
            abrir()
            fechar()		   
        
    */

    /* b) Usei esse exemplo como caso de uso para a interface, pois os objetos pensados são de diferentes naturezas porém, são interagidos na 
          mesma forma para as pessoas pois esses métodos podem ser feitos com ambos objetos. Mas a forma de como vai ser feito os métodos abrir e 
          fechar vão ser diferentes pra cada objeto. */	
		  
   // c) Esboço do código 
	
	    interface Openable {
		    void open ( void );
		    void close( void );
	    }
