package exercicio_10_8;

import edu.udc.psw.Politico;

public class TestePonto2DSerial {

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
