package edu.udc.psw;

public class ListaEncadeada {
	private NoLista inicio;
	private NoLista fim;
	
	private int tamanho = 0;
	
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean isVazia() {
		if(tamanho == 0)
			return true;
		return false;
	}
	public void inserir(Object obj, int pos) {
		NoLista novo = new NoLista();
		novo.dado = obj;
		novo.proximo = null;
		novo.anterior = null;
		
		if(pos < 1 || pos > tamanho+1) {
			return;
		}
		
		if(tamanho == 0) {			//LISTA VAZIA
			tamanho++;
			inicio = novo;
			fim = novo;
			return;
		}
		
		if(pos == 1) {		//NOVO INICIO
			novo.proximo = inicio;
			inicio.anterior = novo;
			inicio = novo;
			tamanho++;
			return;
		}
		
		if(pos == tamanho + 1) {		//NOVO fim		//juntando a conndição lista vazia e o novo fim cria-se a função inserirFim
			novo.anterior = fim;
			fim.proximo = novo;
			fim = novo;
			tamanho++;
			return;
		}
		
		//INSERIR NO MEIO DA LISTA
		NoLista aux = inicio;
		int cont = 1;
		
		while(cont < pos) {
			aux = aux.proximo;
			cont++;
		}
		
		novo.anterior = aux.anterior;
		novo.proximo = aux;
		aux.anterior.proximo = novo;
		aux.anterior = novo;
		
		tamanho++;
	}
	
	public Object remover(int pos) {			///REMOVENDO UNICO ELEMENTO DA LISTA
		NoLista aux = inicio;
		int cont = 1;
		
		if(tamanho == 0)
			return null;
		
		if(pos > tamanho)
			return null;
		
		if(tamanho == 1) {
			Object dado = inicio.dado;
			
			inicio = null;
			fim = null;
			
			tamanho--;
			
			return dado;
		}
		
		if(pos == 1) {				//REMOVER INICIO
			Object dado = inicio.dado;
			
			inicio.proximo.anterior = null;		//corta a volta 
			inicio = inicio.proximo;			//aponta o inicio para o proximo
			
			tamanho--;
			
			return dado;
			//return removerFim();
		}
		
		if(pos == tamanho) {			//REMOVER O FIM
			Object dado = fim.dado;
			
			fim.anterior.proximo = null;		//corta a volta 
			fim = fim.anterior;			//aponta o inicio para o proximo
			
			tamanho--;
			
			return dado;
		}
		
		///REMOVER NÓ DO MEIO DA LISTA
		
		while(cont < pos) {
			aux = aux.proximo;
			cont++;
		}
		
		Object dado = aux.dado;
		
		aux.anterior.proximo = aux.proximo;
		aux.proximo.anterior = aux.anterior;
		
		tamanho--;
		return dado;
	}
	
	public Object pesquisar(int pos) {
		NoLista aux = inicio;
		int cont = 1;
		
		if(tamanho == 0)
			return null;
		
		if(pos > tamanho)
			return null;
		
		while(cont < pos) {
			aux = aux.proximo;
			cont++;
		}
		
		return aux.dado;
		
	}
}
