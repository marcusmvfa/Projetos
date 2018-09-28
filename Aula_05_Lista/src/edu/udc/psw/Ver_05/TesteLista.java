package edu.udc.psw.Ver_05;

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
	//////////////////////////PADRAO ITERADOR
	public static void mostrarLista(ListaEncadeada lista) {
		//int numElem = lista.getTamanho();
		
		System.out.println("Lista com "+ lista.getTamanho() + " nós.");
		
		Iterador it = lista.getInicio();
		Object obj = it.getObject();
		int i = 1;
		while(obj != null) {
			System.out.println("Iterador na pos: " + i++ + " -> " + obj);
			obj = it.proximo();
		}
		
		System.out.println("Fim da lista");
	}

}
