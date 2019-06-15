package edu.udc.psw.desenho.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import edu.udc.psw.desenho.Aplicacao;
import edu.udc.psw.desenho.Documento;
import edu.udc.psw.desenho.formas.Circulo;
import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.formas.Linha;
import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.desenho.formas.Retangulo;
import edu.udc.psw.desenho.formas.Triangulo;
import edu.udc.psw.util.Iterator;
import edu.udc.psw.util.LinkedList;


public class ArquivoSerial implements ArquivoFormas{
private File file;
private String str;
	
	public ArquivoSerial(File file)
	{
		this.file = file;
	}

	public void lerFormas(Documento doc) {		
		ObjectInputStream input = null;
		//doc.limparLista();

		try {
			input = new ObjectInputStream(new FileInputStream (file));
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			
			try {
				while((str = buffer.readLine()) != null ){
					
					try {
						Object leitura = input.readObject();
						System.out.println(leitura);
						
						String[] corte = leitura.toString().split(" ");
						
						if(corte[0].equals("Ponto")){
							Ponto ponto = Ponto.fabricar(corte[1] + " " + corte[2]);
							doc.inserir(ponto);
						}
						if(corte[0].equals("Linha")){
							FormaGeometrica linha = Linha.fabricar(corte[1] + " "
						+ corte[2] + " " + corte[3] + " " + corte[4]);
							doc.inserir(linha);
						}
						if(corte[0].equals("Circulo")){
							FormaGeometrica circulo = Circulo.fabricar(corte[1] + " "
						+ corte[2] + " " + corte[3] + " " + corte[4]);
							doc.inserir(circulo);
						}
						if(corte[0].equals("Retangulo")){
							FormaGeometrica retangulo = Retangulo.fabricar(corte[1] + " "
						+ corte[2] + " " + corte[3] + " " + corte[4]);
							doc.inserir(retangulo);
						}
						if(corte[0].equals("Triangulo")){
							FormaGeometrica triangulo = Triangulo.fabricar(corte[1] + " " 
						+ corte[2] + " " + corte[3] + " " + corte[4] + " " + corte[5] + " " + corte[6]);
							doc.inserir(triangulo);
						}
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void salvarFormas(Iterator<FormaGeometrica> it) {
		ObjectOutputStream output; // objeto utilizado para gerar saída de texto no arquivo
		
		try {
			output = new ObjectOutputStream(new FileOutputStream (file));
			
			FormaGeometrica forma;
			

			forma = it.data();
			while (forma != null) {
				output.writeObject(forma.getClass().getSimpleName() + " " + forma.toString() + " \n");
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
