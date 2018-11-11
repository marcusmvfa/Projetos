/*
ObejctInputStream in;

	in = new ObejctInputStream(new FileInputStream("Nome"));
	
	Politicos p;
	p = new Politico(...);
	
	out.writeObject(p);
	
	p = (Politico) in.readObject();
*/
package exercicio_10_9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import edu.udc.psw.Politico;
import exercicio_10_4.Ponto2D;

public class CriarArquivoSerial {
	Retangulo retangulo = new Retangulo();
	private ObjectOutputStream out;
	
	public void open() {
		try {
			out = new ObjectOutputStream(new FileOutputStream("c:\\Users\\Marcus\\ArquivosPSW\\SerialRetangulo.txt"));
		}
		catch(IOException e) {
			
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void adicionaRegistro() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Para terminar, digite <ctrl> d no UNIX/Linux/Mac OS X\n" + 
						"ou <ctrl> Z no Windows.\n\n");
		
		System.out.println("Informe o comprimento e altura do retangulo:");
		
		while(sc.hasNext()) {							//Laço é encerrado ao ler EOF (fim do arquivo)
			retangulo.setComprimento(sc.nextFloat());
			retangulo.setAltura(sc.nextFloat());
			
			System.out.println("Pressione ctrl + z \n");
			if(retangulo.getComprimento() > 0 || retangulo.getAltura() > 0) {
				try {
					out.writeObject(retangulo);			//Adiciona ao arquivo
				} catch (IOException e) {
					e.printStackTrace();			//sequencia de chamadas até onde encontrou o erro (primeiro passo para debugar)
					System.exit(0);
				}
			} else {
				System.out.println("O numero deve ser igual ou maior que 0.");
			}
		}
		//out.writeObject(politico);
	}
	
	public void closeFile() {
		if(out != null) {
			try {
				out.close();
				out = null;
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}