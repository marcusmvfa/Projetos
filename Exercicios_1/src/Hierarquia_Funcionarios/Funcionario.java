package Hierarquia_Funcionarios;
import java.util.Scanner;

public class Funcionario extends Pessoa{
	
	public String dataAdmissao;
	public String cargo;
	public Scanner sc = new Scanner(System.in);
	
	Pessoa p = new Pessoa();
	
	Funcionario(){
		super.nome = "";
		super.CPF = 0;
		super.dataNasc = "";
		dataAdmissao = "";
		cargo = "";
	}
	
	public void entrada() {
		System.out.println("Nome:");
		super.nome = sc.nextLine();
		System.out.println("Data de nascimento:");
		super.dataNasc = sc.nextLine();
		System.out.println("CPF:");
		super.CPF = Integer.parseInt(sc.nextLine());
		System.out.println("Data de admissão:");
		dataAdmissao = sc.nextLine();
		
		System.out.println("Cargo:");
		cargo = sc.nextLine();
	}
	
	
	public String toString() {
		return String.format("Nome: %s\nNascimento: %s\nCPF: %d\nData de admissão: %s \nCargo: %s", super.nome, super.dataNasc, super.CPF, dataAdmissao, cargo);
	}
}
