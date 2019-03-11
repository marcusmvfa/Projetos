package exercicio_10_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.udc.psw.LerArqTexto;
import Figuras.Retangulo;

public class LerArqFormas extends LerArqTexto{
	Scanner scanner;
	
	public void openFile() {
			try {
				//scanner = new Scanner( new File("c:\\Users\\Marcus\\politicos.txt") );
				scanner = new Scanner( new File("c:\\Users\\Marcus\\ArquivosPSW\\Formas.txt") );
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
//Utilizar a lista encadeada já implementada(Se conseguir)
//Fazer um array de Formas(Inteface) /Depois leio cada linha do arvquivo e faço a configuração / pego o primeiro valor e instancio a forma
//Depois configuro cada forma geometrica
	public void lerArquivo() {
		Retangulo retangulo = new Retangulo();
		Triangulo triangulo = new Triangulo();
		Circulo circulo = new Circulo();
		Formas forma = new Formas();
		
		System.out.printf("Registro de Formas:\n\n");
		
		while (scanner.hasNext()) { // Laço é encerrado ao ler EOF (fim do arquivo)
			forma.setTipo(scanner.nextInt());
			if(forma.getTipo() == 1) {
				retangulo.setComprimento(scanner.nextFloat());
				retangulo.setAltura(scanner.nextFloat());
				
				System.out.printf("Retangulo:\nBase: %.2f Altura: %.2f\n", retangulo.getComprimento(), retangulo.getAltura());
			}
			else if(forma.getTipo() == 2) {
				triangulo.setBase(scanner.nextFloat());
				triangulo.setAltura(scanner.nextFloat());
			}
			else if(forma.getTipo() == 3) {
				circulo.setRaio(scanner.nextFloat());
			}
			
			if()
			System.out.printf("Forma: %s Base: %.2f Altura: %.2f\n", retangulo.getComprimento(), retangulo.getAltura());
		}
	}
}
