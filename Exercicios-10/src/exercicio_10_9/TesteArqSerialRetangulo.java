package exercicio_10_9;

public class TesteArqSerialRetangulo {

	public static void main(String[] args) {
		CriarArquivoSerial criarArq = new CriarArquivoSerial();
		LerArquivoSerial lerArq = new LerArquivoSerial();
		
		criarArq.open();
		criarArq.adicionaRegistro();
		criarArq.closeFile();
		
		lerArq.openFile();
		lerArq.lerArquivo();
		lerArq.closeFile();

	}

}
