package edu.udc.psw.desenho;

import javax.swing.JFrame;

import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.desenho.gui.FrameDesenho;
import edu.udc.psw.util.Iterator;
import edu.udc.psw.util.LinkedList;

public class Aplicacao {

	private static Aplicacao aplicacao;
	
	private LinkedList<Ponto> lista;
	
	public void limparLista() {
		//removerTudo();
	}
	
	public void inserir(Ponto p) {
		lista.addLast(p);
	}
	public Iterator<Ponto> getIterator() {
		return lista.getFirst();
	}
	public int getListSize() {
		return lista.getSize();
	}
	
	public static Aplicacao getAplicacao() {
		if(aplicacao == null) {
			aplicacao = new Aplicacao();
		}
		return aplicacao;
	}
	
	private Aplicacao() {
		lista = new LinkedList<>();
		
		FrameDesenho frame = new FrameDesenho();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Aplicacao.getAplicacao();
	}

}
