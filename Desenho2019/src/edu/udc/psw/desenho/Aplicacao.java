package edu.udc.psw.desenho;

import javax.swing.JFrame;

import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.desenho.gui.FrameDesenho;
import edu.udc.psw.util.Iterator;
import edu.udc.psw.util.LinkedList;


//Classe que implementa o padrão Singleton
public class Aplicacao {

	private static Aplicacao aplicacao;
	
	private Documento doc;
	
	public static Aplicacao getAplicacao() {
		if(aplicacao == null) {
			aplicacao = new Aplicacao();
		}
		return aplicacao;
	}
	
	public Documento getDocumentAtivo() {
		return doc;
	}
	
	private Aplicacao() {
		doc = new Documento();
		
		FrameDesenho frame = new FrameDesenho(doc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Aplicacao.getAplicacao();
	}

}
