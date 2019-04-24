package edu.udc.psw.desenho.formas.manipulador;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.formas.Ponto;

public class ManipuladorPonto implements FormaGeometrica {
	private Ponto ponto;
	
	public ManipuladorPonto(Ponto p) {
		ponto = p;
	}

	@Override
	public void desenhar(Graphics g) {
		g.drawLine((int) ponto.getX(), (int) ponto.getY(), 
				(int) ponto.getX(), (int) ponto.getY());
		
	}

	@Override
	public FormaGeometrica fabricar(String forma) {
		// TODO Auto-generated method stub
		return null;
	}

}
