package exercicio_10_4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import edu.udc.psw.CriarArqTexto;
import edu.udc.psw.Politico;

public class CriarArq extends CriarArqTexto {

	
	public void openFile() {
		try {
			objEscrita = new FileWriter("c:\\Users\\Marcus\\Ponto2D.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}	
	}
	
	public void adcionaRegistros() {
		Ponto2D ponto = new Ponto2D();
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Para terminar, digite <ctrl> d no UNIX/Linux/Mac OS X\n" + 
						"ou <ctrl> Z no Windows.\n\n");
		
		System.out.println("Informe os dados do ponto2D:\n");
		
		while(sc.hasNext()) {							//Laço é encerrado ao ler EOF (fim do arquivo)
			ponto.setX(sc.nextDouble());
			ponto.setY(sc.nextDouble());
			
			if(ponto.getX() > 0 && ponto.getY() > 0 ){
				try {
					objEscrita.append(				//Adiciona ao arquivo
							String.format("%.2f %.2f\n", ponto.getX(), ponto.getY()));
				} catch (IOException e) {
					e.printStackTrace();			//sequencia de chamadas até onde encontrou o erro (primeiro passo para debugar)
					System.exit(0);
				}
			} else {
				System.out.println("O numero deve ser maior que 0.");
			}
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
