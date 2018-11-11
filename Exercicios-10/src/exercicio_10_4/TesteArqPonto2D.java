package exercicio_10_4;

import edu.udc.psw.CriarArquivoSerial;
import edu.udc.psw.LerArqTexto;
import edu.udc.psw.LerArquivoSerial;

public class TesteArqPonto2D {

	public static void main(String[] args) {
		CriarArq f = new CriarArq();
		LeituraArquivo l = new LeituraArquivo();
		//CriarArquivoSerial criararquivoSerial = new CriarArquivoSerial();
		//LerArquivoSerial lerarquivoserial = new LerArquivoSerial();
		
		f.openFile();
		f.adcionaRegistros();
		f.closeFile();
		
		l.openFile();
		l.lerArquivo();
		l.closeFile();
/*
		criararquivoSerial.open();
		criararquivoSerial.adicionaRegistro();
		criararquivoSerial.closeFile();
		
		lerarquivoserial.openFile();
		lerarquivoserial.lerArquivo();
		lerarquivoserial.closeFile();
*/
	}

}
