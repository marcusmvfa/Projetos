package exercicio_10_4;

import edu.udc.psw.LerArqTexto;

public class TesteArqPonto2D {

	public static void main(String[] args) {
		CriarArq f = new CriarArq();
		LeituraArquivo l = new LeituraArquivo();
		
		f.openFile();
		f.adcionaRegistros();
		f.closeFile();
		
		l.openFile();
		l.lerArquivo();
		l.closeFile();

	}

}
