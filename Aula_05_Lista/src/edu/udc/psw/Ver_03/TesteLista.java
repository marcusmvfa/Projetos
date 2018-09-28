package edu.udc.psw.Ver_03;

public class TesteLista {

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		
		lista.inserirInicio(new Integer(5));
		lista.inserirInicio(new Integer(8));
		lista.inserir(new Integer(3), 3);
		lista.inserirFim(new Integer(110));
		lista.inserirFim(new Integer(4));

		mostrarLista(lista);
		
		System.out.println("RemoverInicio: " +lista.removerInicio());
		System.out.println("RemoverFim: " +lista.removerFim());
		System.out.println("Remover pos 2: " +lista.remover(2));
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
