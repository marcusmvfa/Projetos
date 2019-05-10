package edu.udc.psw.desenho.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import edu.udc.psw.desenho.Aplicacao;
import edu.udc.psw.desenho.Documento;
import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.formas.Linha;
import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.util.Iterator;
import edu.udc.psw.util.LinkedList;


public class ArquivoTexto implements ArquivoFormas{
private File file;
private String str;
	
	public ArquivoTexto(File file)
	{
		this.file = file;
	}

	public void lerFormas(Documento doc) {		
		Scanner input = null;
		//doc.limparLista();

		try {
			input = new Scanner( file );
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			
			try {
				while((str = buffer.readLine()) != null ){
					String[] corte = str.split(" ");
					
					if(corte[0].equals("Ponto")){
						Ponto ponto = Ponto.fabricar(corte[1] + " " + corte[2]);
						doc.inserir(ponto);
					}
					if(corte[0].equals("Linha")){
						FormaGeometrica linha = Linha.fabricar(corte[1] + " " + corte[2] + " " + corte[3] + " " + corte[4]);
						doc.inserir(linha);
					}
				}
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			while (input.hasNextLine()) {
//				String str = input.nextLine();
//				Ponto forma = Ponto.fabricar(str);//FAzer verificação de cada forma// Fazer uns if's para cada forma para então chamar o fabricar da forma especifica 	
//				Linha linha = Linha.fabricarLinha(str);
//				
//				
//				doc.inserir(forma);
//				doc.inserir(linha);
//			}
			
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
