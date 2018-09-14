package Exercicio_1_12;
import java.util.Scanner;
public class Data {
	private byte dia;
	private byte mes;
	private short ano;
	Scanner sc = new Scanner(System.in);
	
	public Data() {
		dia = 1;
		mes = 1;
		ano = 2000;
	}
	
	public Data(byte dia, byte mes, short ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public String toString() {
		return String.format("%02d/%02d/%04d", dia, mes, ano);
	}
/*	
	public void LeituraData() {
		System.out.println("Data");
		System.out.println("Dia");
		dia = sc.nextInt();
		System.out.println("Mes");
		mes = sc.nextInt();
		System.out.println("Ano");
		ano = sc.nextInt();
	}
	public void MostrarData() {
		System.out.println("Data: " + dia + "/" + mes + "/" + ano);
	}*/
}
