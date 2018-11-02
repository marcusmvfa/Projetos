package exercicio_10_2;

import java.util.Scanner;

public class Matriz {
	private int i;
	private int j;
	private int linhas = 3;
	private int colunas = 3;
	int valor[][] = new int[linhas][colunas];
	
	Scanner sc = new Scanner(System.in);
	
	public void entraMatriz() {
		System.out.println("Entre com a matriz 3x3");
		for(i=0; i<linhas; i++) {
			for(j=0; j<colunas; j++) {
				valor[i][j] = sc.nextInt();
			}
		}
	}
	
	public void mostrarMatriz() {
		System.out.println("Matriz:");
		for(i=0; i<linhas; i++) {
			System.out.printf("\n");
			for(j=0; j<colunas; j++) {
				System.out.printf("%d ", valor[i][j]);
			}
		}
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = 3;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = 3;
	}
	

}
