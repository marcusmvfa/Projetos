package Exercicio_1_12;

import java.util.Scanner;

public class Principal2 {
	
	public static void entrada(DataHora a) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hora");
		System.out.println("Entre com a(s) hora(s):");
		a.hora.hora = sc.nextByte();
		System.out.println("Entre com o(s) minuto(s):");
		a.hora.minuto = sc.nextByte();
		System.out.println("Entre com a(s) segundo(s):");
		a.hora.segundo = sc.nextByte();
		System.out.println("Data");
		System.out.println("Entre com o dia");
		a.data.dia = sc.nextByte();
		System.out.println("Entre com o mes");
		a.data.mes = sc.nextByte();
		System.out.println("Entre com o ano");
		a.data.ano = sc.nextShort();
	}

	public static void main(String[] args) {      //Composição - quando destrói um dos objetos, todo o objeto é destruído
		DataHora dh = new DataHora();			  //Agregação - quando se destrói, os outros objetos ainda existem
		
		entrada(dh);
		System.out.println(dh);

	}

}
