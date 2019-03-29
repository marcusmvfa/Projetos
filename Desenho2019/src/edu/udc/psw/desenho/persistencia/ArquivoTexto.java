package edu.udc.psw.desenho.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import edu.udc.psw.desenho.Aplicacao;
import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.util.Iterator;
import edu.udc.psw.util.LinkedList;


public class ArquivoTexto {
private File file;
	
	public ArquivoTexto(File file)
	{
		this.file = file;
	}

	public void lerFormas() {
		Aplicacao.getAplicacao().limparLista();
		
		Scanner input = null;

		try {
			input = new Scanner( file );
			while (input.hasNextLine()) {
				String str = input.nextLine();
				Ponto forma = Ponto.fabricarPonto(str);
				
				
				Aplicacao.getAplicacao().inserir(forma);
			}
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void salvarFormas(Iterator<FormaGeometrica> it) {
		FileWriter output; // objeto utilizado para gerar saída de texto no arquivo
		
		try {
			output = new FileWriter(file);
			
			FormaGeometrica forma;
			

			forma = it.data();
			while (forma != null) {
				output.append(forma.getClass().getSimpleName() + " " + forma.toString() + "\n");
				forma = it.next();
			}
			
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void lerArquivos() {
		Scanner leitura = null ;
		
		try {
			leitura = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(leitura.hasNext()) {
			Aplicacao.getAplicacao();
		}
		
		
	}
}
