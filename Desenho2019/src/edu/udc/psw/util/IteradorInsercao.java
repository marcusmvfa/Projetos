package edu.udc.psw.util;

public interface IteradorInsercao<T> extends Iterator<T> {
	void inserirAntes(T dado);
	void inserirDepois(T dado);
}
