package Passaro;

public class Teste {

	public static void main(String[] args) {
		Sistema_Passaros sp = new Sistema_Passaros();
		Passaros a = new Passaros("Canario", 50.0f, 23, 7);
		Passaros b = new Passaros("Pardal", 20.0f, 3, 2);
		Passaros c = new Passaros("Calopsita", 45.0f, 41, 1);
		Passaros d = new Passaros("Urubu", 10.0f, 100, 12);

		sp.incluir(a);
		sp.incluir(b);
		sp.incluir(c);
		sp.incluir(d);
		
		System.out.println("Valor total do estoque: " + sp.valorEstoque());
		System.out.println("Idade do Passaro a mais tempo na loja: " + sp.velho());
	}
}
