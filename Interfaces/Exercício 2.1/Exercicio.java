// Interface 1
// Objetos pensados: agenda, relogio e despertador 

// Representação

/* "alerta":
        consultar()
	      aviso()
*/

// Sintaxe em Java

interface Pluggable {
    void consult(int hour);    /* Nos dois métodos é usado o parâmetro hour para informar os horário com compromissos marcados no cronograma na lista  */
    void Warning(int hour);   
}


// Interface 2
// Objetos pensados: livro, revista e jornal

// Representação

/* "Marcável":
        marcar()
	      ler()
*/

// Sintaxe em Java

interface Markable {
    int mark(void);    // Nesse método é feito o retorno de um inteiro ao qual informa o número da página que o leitor parou de ler
    void read(int pages);  // Nesse método é usado o parâmetro pages para informar a quantidade de páginas que o leitor irá ler 
}
