package edu.udc.psw;

public class TestePolitico {

	public static void main(String[] args) {
		CriarArqTexto arq = new CriarArqTexto();
		LerArqTexto lerArq = new LerArqTexto();
		
		arq.openFile();
		arq.adcionaRegistros();
		arq.closeFile();
		
		lerArq.openFile();
		lerArq.lerArquivo();
		lerArq.closeFile();

	}

}
