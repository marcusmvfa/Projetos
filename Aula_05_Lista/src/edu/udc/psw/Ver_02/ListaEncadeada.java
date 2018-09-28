package edu.udc.psw.Ver_02;

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
	
	public void inserirInicio(Object obj) {
		NoLista novo = new NoLista();
		novo.dado = obj;
		novo.proximo = inicio;
		novo.anterior = null;
		
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		}else {
			inicio.anterior = novo;
			inicio = novo;
		}
		
		tamanho++;
	}
	
	public void inserirFim(Object obj) {
		NoLista novo = new NoLista();
		novo.dado = obj;
		novo.proximo = null;
		novo.anterior = fim;
		
		if(fim != null) 
			fim.proximo = novo;
			
		fim = novo;
		
		if(inicio == null)
			inicio = novo;
		
		tamanho++;
		
	}
	
	public void inserir(Object obj, int pos) {
		
		
		if(pos < 1 || pos > tamanho + 1) {
			return;
		}
		
		
		if(pos == 1) {		//NOVO INICIO
			inserirInicio(obj);
			return;
		}
		
		if(pos == tamanho + 1) {		//NOVO fim	
			inserirFim(obj);
			return;
		}
		
		
		NoLista novo = new NoLista();
		novo.dado = obj;
		novo.proximo = null;
		novo.anterior = null;
		
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
	
	public Object removerInicio() {
		if(inicio == null)
			return null;
		
		Object dado = inicio.dado;
		
		if(inicio == fim) {//if(tamanho == 1)
			inicio = null;
			fim = null;
		}else {
			inicio.proximo.anterior = null;
			inicio = inicio.proximo;
		}
		
		tamanho--;
		
		return dado;
	}
	public Object removerFim() {
		if(fim == null)
			return null;
		
		Object dado = fim.dado;
		
		if(inicio == fim) {//if(tamanho == 1)
			inicio = null;
			fim = null;
		}else {
			fim.anterior.proximo = null;
			fim = fim.anterior;
		}
		
		tamanho--;
		
		return dado;
	}
	public Object remover(int pos) {			///REMOVENDO UNICO ELEMENTO DA LISTA
		if(pos < 1 || pos > tamanho)
			return null;
		
		
		if(pos == 1) {				//REMOVER INICIO
			return removerInicio();
		}
		
		if(pos == tamanho) {			//REMOVER O FIM			
			return removerFim();
		}
		
		NoLista aux = inicio;
		int cont = 1;
		
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
