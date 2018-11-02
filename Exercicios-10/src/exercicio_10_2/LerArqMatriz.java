package exercicio_10_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.udc.psw.LerArqTexto;
import Figuras.Retangulo;

public class LerArqMatriz extends LerArqTexto{
	Scanner scanner;
	
	public void openFile() {
			try {
				//scanner = new Scanner( new File("c:\\Users\\Marcus\\politicos.txt") );
				scanner = new Scanner( new File("c:\\Users\\Marcus\\ArquivosPSW\\Matriz.txt") );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(0);
			}
	}
	
	public void closeFile() {
		if(scanner != null) {
			scanner.close();
			scanner = null;
		}
	}
	
	public void lerArquivo() {
		//Retangulo retangulo = new Retangulo();
		Matriz mat = new Matriz();
		
		System.out.printf("Matriz:");
		
		while (scanner.hasNext()) { // Laço é encerrado ao ler EOF (fim do arquivo)
			for(int i=0; i<mat.getLinhas(); i++) {
				for(int j=0; j<mat.getColunas(); j++) {
					mat.valor[i][j] = scanner.nextInt();
				}
			}
			for(int i=0; i<mat.getLinhas(); i++) {
				System.out.println("\n");
				for(int j=0; j<mat.getColunas(); j++) {
					System.out.printf("%d ", mat.valor[i][j]);
				}
			}
		}
	}
}
