package Exercicio_1_10;
import java.util.Scanner;
public class Professor {
	
	String nome;
	String disciplina;
	Scanner sc = new Scanner(System.in);
	Professor(){
		nome = new String();
		disciplina = new String();
	}

	Professor(String nome, String disc){
		this.nome = nome;
		this.disciplina = disc;
	}
	
	public void Leitura() {
		nome = sc.nextLine();
		disciplina = sc.nextLine();
	}
	public void Mostrar() {
		System.out.println("Nome do Professor:" + nome);
		System.out.println("Nome do Disciplina:" + disciplina);
	}
	
}
