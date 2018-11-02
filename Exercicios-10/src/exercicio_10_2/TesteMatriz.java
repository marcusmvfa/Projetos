package exercicio_10_2;

public class TesteMatriz {

	public static void main(String[] args) {
		CriarArqMatriz criarArq = new CriarArqMatriz();
		LerArqMatriz lerArq = new LerArqMatriz();
		
		criarArq.openFile();
		criarArq.adcionaRegistros();
		criarArq.closeFile();

		lerArq.openFile();
		lerArq.lerArquivo();
		lerArq.closeFile();
	}

}
