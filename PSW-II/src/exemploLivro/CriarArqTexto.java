package exemploLivro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CriarArqTexto {
	protected FileWriter objEscrita;
	
	public void openFile() {
		try {
			objEscrita = new FileWriter("C:\\Users\\Marcus\\Documents\\Faculdade\\PSW II\\Pontos.txt");
//			objEscrita = new FileWriter("D:\\Pontos.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}		
	}
	
	public void listaArquivo(ListaEncadeada<Ponto2D> lista) {
		Iterador<Ponto2D> it = lista.getInicio();
		Ponto2D ponto;
		
		try {
			while((ponto = it.proximo())!= null) {
				//objEscrita.append(String.format("Ponto: %.2f %.2f ", ponto.getX(), ponto.getY()));
				objEscrita.append(String.format(ponto.toString()+"\n"));
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void adcionaRegistros() {
		Politico politico = new Politico();
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
					objEscrita.append(				//Adiciona ao arquivo
							String.format("%5s  %5d  %s \n", politico.getPartido(), politico.getNumero(), politico.getNome()));
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
