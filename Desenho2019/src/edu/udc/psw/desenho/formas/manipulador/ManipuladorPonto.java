package edu.udc.psw.desenho.formas.manipulador;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.Ponto;

public class ManipuladorPonto implements ManipuladorFormaGeometrica {
	private Ponto ponto;
	
	public ManipuladorPonto(Ponto p) {
		ponto = p;
	}
	
	@Override
	public void click(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void press(int x, int y) {
	}

	@Override
	public void release(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void drag(int x, int y) {
	}

	@Override
	public void paint(Graphics g) {
		g.drawLine((int) ponto.getX(), (int) ponto.getY(), 
				(int) ponto.getX(), (int) ponto.getY());
	}

}
