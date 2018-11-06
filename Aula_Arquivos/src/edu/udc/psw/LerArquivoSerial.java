package edu.udc.psw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LerArquivoSerial {
	Scanner scanner;
	ObjectInputStream in;

	public void openFile() {
		try {
			// scanner = new Scanner( new File("c:\\Users\\Marcus\\politicos.txt") );
			in = new ObjectInputStream(new FileInputStream("c:\\Users\\Marcus\\ArquivosPSW\\SerialPoliticos2.txt"));
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
		Politico politico = new Politico();

		System.out.printf("Registros de politicos:\n\n");

		try {
			politico = (Politico) in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(politico);
	}
}