package edu.udc.psw.desenho.formas.manipulador;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.Linha;
import edu.udc.psw.desenho.formas.Ponto;

public class ManipuladorLinha implements ManipuladorFormaGeometrica {
	private Linha linha;
	
	public ManipuladorLinha(Linha l) {
		linha = l;
	}
	
	
	public void click(int x, int y) {
	}

	
	public void press(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			linha.setA(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Ponto(x, y);
		try {
			linha.setB(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void release(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			linha.setB(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void drag(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			linha.setB(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		try {
			g.drawLine((int) linha.getA().getX(), (int) linha.getA().getY(), 
					(int) linha.getB().getX(), (int) linha.getB().getY());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
