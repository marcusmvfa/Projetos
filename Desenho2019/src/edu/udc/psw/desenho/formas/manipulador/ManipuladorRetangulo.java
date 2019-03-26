package edu.udc.psw.desenho.formas.manipulador;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.desenho.formas.Retangulo;

public class ManipuladorRetangulo implements ManipuladorFormaGeometrica {
	private Retangulo retangulo;
	
	public ManipuladorRetangulo(Retangulo r) {
		retangulo = r;
		System.out.println("Retangulo Instanciado!");
	}
	
	@Override
	public void click(int x, int y) {
	}

	@Override
	public void press(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			retangulo.setA(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Ponto(x, y);
		try {
			retangulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void release(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			retangulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void drag(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			retangulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		int xa = 0;
		try {
			xa = (int) retangulo.getA().getX();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int xb = 0;
		try {
			xb = (int) retangulo.getB().getX();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ya = 0;
		try {
			ya = (int) retangulo.getA().getY();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int yb = 0;
		try {
			yb = (int) retangulo.getB().getY();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawRect(xa < xb ? xa : xb, ya < yb ? ya : yb, 
				(int) retangulo.base(), (int) retangulo.altura() );
	}

}
