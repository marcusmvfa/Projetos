package edu.udc.psw;

public class TesteLista {

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.inserir(new Integer(5), 1);
		lista.inserir(new Integer(8), 2);
		lista.inserir(new Integer(3), 3);
		lista.inserir(new Integer(110), 4);
		lista.inserir(new Integer(4), 5);

		mostrarLista(lista);

	}
	
	public static void mostrarLista(ListaEncadeada lista) {
		int numElem = lista.getTamanho();
		
		System.out.println("Lista com "+ numElem + "nós.");
		for(int i = 1; i <= numElem; i++) {
			System.out.println(i + " -> " + lista.pesquisar(i));
		}
		System.out.println("Fim da lista");
	}

}
