package exercicio_1_7;

public class Encapsula_Contador {//Escopo determina aonde determinado elemento é válido
	private int cont;			 //Interface são métodos que podem ser acessados de fora da classe
	
	public Encapsula_Contador() {
		cont = 0;
	}
	
	public void incrementar() {
		cont++;
	}
	void zerar() {				 //Visibilidade de pacote(visto apenas dentro do pacote
		cont = 0;				 //Classe seria o conceito, a ideia de algo
	}							 //Objeto seria a materialização
	public int retornaValor() {
		return cont;
	}
}
