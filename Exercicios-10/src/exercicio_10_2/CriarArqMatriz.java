package exercicio_10_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Figuras.Retangulo;
import edu.udc.psw.CriarArqTexto;


public class CriarArqMatriz extends CriarArqTexto {

	
	public void openFile() {
		try {
			objEscrita = new FileWriter("c:\\Users\\Marcus\\ArquivosPSW\\Matriz.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}	
	}
	
	public void adcionaRegistros() {
		Matriz mat = new Matriz();
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Para terminar, digite <ctrl> d no UNIX/Linux/Mac OS X\n" + 
						"ou <ctrl> Z no Windows.\n\n");
		
		//Utilizar a função de entrada da matriz no lugar do while
		//Como a função joga os valores para a memória, só preciso fazer um for parecido com o da matriz
		//E salvar no arquivo
		mat.entraMatriz();
			
			if(mat.valor[0][0] > -1){
				try {
					for(int i=0; i<mat.getLinhas(); i++) {
						for(int j=0; j<mat.getColunas(); j++) {
							objEscrita.append(					//Adiciona ao arquivo
								String.format("%d ", mat.valor[i][j]));
							
						}
					}
				} catch (IOException e) {
					e.printStackTrace();			//sequencia de chamadas até onde encontrou o erro (primeiro passo para debugar)
					System.exit(0);
				}
			} else {
				System.out.println("O numero deve ser maior que 0.");
			}
		}
	public void closeFile() {
		if(objEscrita != null) {
			try {
				objEscrita.close();
				objEscrita = null;
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
