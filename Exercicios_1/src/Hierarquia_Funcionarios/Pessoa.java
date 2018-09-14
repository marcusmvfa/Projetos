package Hierarquia_Funcionarios;
import java.util.Scanner;

public class Pessoa {
	public int CPF;
	public String nome;
	public String dataNasc;
	public Scanner sc = new Scanner(System.in);
	
	Pessoa(){
		CPF = 0;
		nome = "";
		dataNasc = "";
	}
	
	/*public void entrada() {
		System.out.println("Entre com o nome:");
		nome = sc.nextLine();
		System.out.println("Entre com o CPF");
		CPF = sc.nextInt();
		System.out.println("Entre com a data de nascimento:");
		dataNasc = sc.nextLine();
	}*/
	
	
}
