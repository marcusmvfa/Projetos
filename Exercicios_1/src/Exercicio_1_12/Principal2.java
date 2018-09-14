package Exercicio_1_12;

public class Principal2 {

	public static void main(String[] args) {      //Composição - quando destrói um dos objetos, todo o objeto é destruído
		DataHora dh = new DataHora();			  //Agregação - quando se destrói, os outros objetos ainda existem
		
		System.out.println(dh);

	}

}
