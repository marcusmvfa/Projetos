package edu.udc.psw.Ver_06;

public class TesteLista {

	public static void main(String[] args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
		
		
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
	public static void mostrarLista(ListaEncadeada<Integer> lista) {
		//int numElem = lista.getTamanho();
		
		System.out.println("Lista com "+ lista.getTamanho() + " nós.");
		
		Iterador<Integer> it = lista.getInicio();
		Integer obj = it.getObject();
		int i = 1;
		while(obj != null) {
			System.out.println("Iterador na pos: " + i++ + " -> " + obj);
			obj = it.proximo();
		}
		
		System.out.println("Fim da lista");
	}

}
