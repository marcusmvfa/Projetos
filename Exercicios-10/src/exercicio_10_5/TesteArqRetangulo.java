package exercicio_10_5;

public class TesteArqRetangulo {

	public static void main(String[] args) {
		CriarArqRetangulo a = new CriarArqRetangulo();
		LerArqRetangulo l = new LerArqRetangulo();
		
		a.openFile();
		a.adcionaRegistros();
		a.closeFile();
		
		l.openFile();
		l.lerArquivo();
		l.closeFile();

	}

}
