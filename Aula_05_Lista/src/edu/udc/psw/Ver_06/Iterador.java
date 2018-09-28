package edu.udc.psw.Ver_06;				

public interface Iterador<T> {				//É com ele que posso andar na lista sem fazer com que ande em todos os elementos da lista
	T getObject();					//Todos os metodosda interface são abstratos
	T proximo();
	T anterior();
}
//////////////////////////////PADRAO ITERADOR
//COM O ITERADOR TEMOS ACESSO APENAS AOS DADOS DO NÓ E NÃO AO NÓ, DESSA FORMA NÃO COLOCA EM RISCO A ESTRUTURA EM QUESTÃO