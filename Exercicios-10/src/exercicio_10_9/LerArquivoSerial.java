package exercicio_10_9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import edu.udc.psw.Politico;
import exercicio_10_4.Ponto2D;

public class LerArquivoSerial {
	Scanner scanner;
	ObjectInputStream in;

	public void openFile() {
		try {
			// scanner = new Scanner( new File("c:\\Users\\Marcus\\politicos.txt") );
			in = new ObjectInputStream(new FileInputStream("c:\\Users\\Marcus\\ArquivosPSW\\SerialRetangulo.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeFile() {
		if (scanner != null) {
			scanner.close();
			scanner = null;
		}
	}

	public void lerArquivo() {
		Retangulo retangulo = new Retangulo();

		System.out.printf("Registros de Retangulo:\n\n");

		try {
			retangulo = (Retangulo) in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(retangulo);
	}
}