/*
ObejctInputStream in;

	in = new ObejctInputStream(new FileInputStream("Nome"));
	
	Politicos p;
	p = new Politico(...);
	
	out.writeObject(p);
	
	p = (Politico) in.readObject();
*/
package edu.udc.psw;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class CriarArquivoSerial {
	Politico politico = new Politico();
	private ObjectOutputStream out;
	
	public void open() {
		try {
			out = new ObjectOutputStream(new FileOutputStream("c:\\Users\\Marcus\\ArquivosPSW\\SerialPoliticos2.txt"));
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
		
		System.out.println("Informe os dados do Politico (numero, nome, partido):");
		
		while(sc.hasNext()) {							//Laço é encerrado ao ler EOF (fim do arquivo)
			politico.setNumero(sc.nextInt());
			politico.setNome(sc.next());
			politico.setPartido(sc.next());
			
			System.out.println("Pressione ctrl + z \n");
			if(politico.getNumero() > 0) {
				try {
					out.writeObject(politico);			//Adiciona ao arquivo
				} catch (IOException e) {
					e.printStackTrace();			//sequencia de chamadas até onde encontrou o erro (primeiro passo para debugar)
					System.exit(0);
				}
			} else {
				System.out.println("O numero deve ser maior que 0.");
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