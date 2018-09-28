package edu.udc.psw.Ver_05;				

public interface Iterador {				//É com ele que posso andar na lista sem fazer com que ande em todos os elementos da lista
	Object getObject();					//Todos os metodosda interface são abstratos
	Object proximo();
	Object anterior();
}
//////////////////////////////PADRAO ITERADOR
//COM O ITERADOR TEMOS ACESSO APENAS AOS DADOS DO NÓ E NÃO AO NÓ, DESSA FORMA NÃO COLOCA EM RISCO A ESTRUTURA EM QUESTÃO