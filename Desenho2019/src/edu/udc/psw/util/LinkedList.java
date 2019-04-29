package edu.udc.psw.util;

public class LinkedList<TIPO> implements Iterable<TIPO> {

	private class ListIterator implements Iterator<TIPO>, java.util.Iterator<TIPO> {
		private Node noAtual;
		
		public ListIterator(Node noAtual) {
			this.noAtual = noAtual;
		}

		@Override
		public TIPO data() {
			if(noAtual == null)
				return null;
			return noAtual.data;
		}

		@Override
		public TIPO next() {
			if(noAtual == null)
				return null;
			TIPO dado = noAtual.data;
			noAtual = noAtual.next;
			return dado;
		}

		@Override
		public TIPO prev() {
			if(noAtual == null)
				return null;
			TIPO dado = noAtual.data;
			noAtual = noAtual.prev;
			return dado;
		}

		@Override
		public boolean hasNext() {
			if(noAtual != null)
				if(noAtual.next != null)
					return true;
			return false;
		}

	}

	private class Node {
		Node next;
		Node prev;
		TIPO data;
	}

	private Node first;
	private Node last;
	private int size;

	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public java.util.Iterator<TIPO> iterator() {
		return new ListIterator(first);
	}

	public Iterator<TIPO> getFirst() {
		return new ListIterator(first);
	}
	
	public Iterator<TIPO> getLast() {
		return new ListIterator(last);
	}

	public void addFirst(TIPO dado) {
		Node novo = new Node();
		novo.data = dado;
		novo.next = first;
		novo.prev = null;
		
		if(first == null)
		{
			first = last = novo;
		}
		else
		{
			first.prev = novo;
			first = novo;
		}
		size++;
	}

	public void addLast(TIPO dado) {
		Node novo = new Node();
		novo.data = dado;
		novo.next = null;
		novo.prev = last;
		
		if(last == null)
		{
			first = last = novo;
		}
		else
		{
			last.next = novo;
			last = novo;
		}
		size++;
	}

	public TIPO removeFirst() {
		if(first == null)
			return null;
		TIPO dado = first.data;
		
		if(first == last) {
			first = null;
			last = null;
		}else {
			first.next.prev = null;
			first = first.next;
		}
		size--;
		
		return dado;
		
		//	no.next.prev = null;
		
		//return null;
	}
	
	public TIPO removeLast() {
		if(first == null)
	        return null;

	    TIPO dado = first.data;
	    
	    if(first == last) {
	    	first = null;
	    	last = null;
	    } else {
	    	last.prev.next = null;
	    	last = last.prev;
	    }
	    size--;
	    
	    
//	    while(no.next != null)
//	        no = no.next;
//
//	    if(no.prev == null)//remover o primeiro e �nico
//	        first = no.next;
//	    else
//	        no.prev.next= null;
		return dado;
	}
	public void removeAll() {
		while(first != null)
			removeFirst();
	}
	
	public void limparLista() {
		while(first != null && last != null) {
			first = null;
			last = null;
		}		
	}
}
