package edu.udc.psw.desenho.formas;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;

public interface FormaGeometrica {
	
	public String toString();
	public void desenhar(Graphics g);

//	public FormaGeometrica fabricar(String forma);
	
	FormaGeometrica clone();
	byte[] toArray();
	
	ManipuladorFormaGeometrica getManipulador();
}
