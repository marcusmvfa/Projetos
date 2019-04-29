package edu.udc.psw.desenho.gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import edu.udc.psw.desenho.Documento;
import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.util.Iterator;

public class PainelTexto extends JTextArea implements PainelOuvinteFormas{

private Documento doc;
private static final long serialVersionUID = 1L;
	
	public PainelTexto(Documento doc) {
		super(8,25);
		this.doc = doc;
		setBackground(new Color(255,255,255));
	}
	
	public void Atualizar() {
		StringBuffer buf = new StringBuffer();
		Iterator<FormaGeometrica> i = doc.getIterator();
		FormaGeometrica forma;
		while((forma = i.next()) != null) {
			buf.append(forma);
			buf.append("\n");
		}
		setText(buf.toString());
	}
	
	public void novaFormaGeometrica(FormaGeometrica forma){
		doc.inserir(forma);
	}

	@Override
	public void formasAlteradas() {
		StringBuffer buf = new StringBuffer();
		Iterator<FormaGeometrica> i = doc.getIterator();
		FormaGeometrica forma;
		while((forma = i.next()) != null) {
			buf.append(forma);
			buf.append("\n");
		}
		setText(buf.toString());
		
	}
}
