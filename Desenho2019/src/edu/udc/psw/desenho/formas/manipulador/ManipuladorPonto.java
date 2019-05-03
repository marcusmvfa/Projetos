package edu.udc.psw.desenho.formas.manipulador;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.formas.Ponto;

public class ManipuladorPonto implements ManipuladorFormaGeometrica {
	private Ponto p;
	
	public ManipuladorPonto(Ponto p) {
		this.p = p;
	}

	public void desenhar(Graphics g) {
		g.drawLine((int) p.getX(), (int) p.getY(), 
				(int) p.getX(), (int) p.getY());
		
	}
	public void paint (Graphics g) {
		g.fillOval(p.getX(), p.getY(), 3 , 3);
	}

	@Override
	public FormaGeometrica clone() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void click(int x, int y) {
		p.setX(x);
		p.setY(y);
	}

	@Override
	public void press(int x, int y) {
		p.setX(x);
		p.setY(y);
	}

	@Override
	public void release(int x, int y) {
		p.setX(x);
		p.setY(y);
	}

	@Override
	public void drag(int x, int y) {
		p.setX(x);
		p.setY(y);
	}
}
