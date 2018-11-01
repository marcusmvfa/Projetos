package exercicio_10_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.udc.psw.LerArqTexto;
import Figuras.Retangulo;

public class LerArqRetangulo extends LerArqTexto{
	Scanner scanner;
	
	public void openFile() {
			try {
				//scanner = new Scanner( new File("c:\\Users\\Marcus\\politicos.txt") );
				scanner = new Scanner( new File("c:\\Users\\Marcus\\ArquivosPSW\\Retangulo.txt") );
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
		Retangulo retangulo = new Retangulo();
		
		System.out.printf("Registro de Retangulo:\nComprimento e Altura\n");
		
		while (scanner.hasNext()) { // Laço é encerrado ao ler EOF (fim do arquivo)
			retangulo.setComprimento(scanner.nextFloat());
			retangulo.setAltura(scanner.nextFloat());
			
			System.out.printf("Comprimento: %.2f\nAltura: %.2f", retangulo.getComprimento(), retangulo.getAltura());
		}
	}
}
