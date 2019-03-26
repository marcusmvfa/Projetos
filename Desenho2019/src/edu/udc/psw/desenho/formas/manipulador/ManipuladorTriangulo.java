package edu.udc.psw.desenho.formas.manipulador;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.desenho.formas.Triangulo;

public class ManipuladorTriangulo implements ManipuladorFormaGeometrica {
	private Triangulo triangulo;
	
	public ManipuladorTriangulo(Triangulo t) {
		triangulo = t;
		System.out.println("Triangulo instanciado!");
	}
	
	@Override
	public void click(int x, int y) {
	}

	@Override
	public void press(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			triangulo.setA(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Ponto(x, y);
		try {
			triangulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Ponto(x, y);
		try {
			triangulo.setC(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void release(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			triangulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Ponto(x, y);
		try {
			triangulo.setC(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void drag(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			triangulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Ponto(x, y);
		try {
			triangulo.setC(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		int xa = 0;
		try {
			xa = (int) triangulo.getA().getX();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int xb = 0;
		try {
			xb = (int) triangulo.getB().getX();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int xc = 0;
		try {
			xc = (int) triangulo.getC().getX();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ya = 0;
		try {
			ya = (int) triangulo.getA().getY();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int yb = 0;
		try {
			yb = (int) triangulo.getB().getY();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int yc = 0;
		try {
			yc = (int) triangulo.getC().getY();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawLine(xa, ya, xb, yb);
		g.drawLine(xb, yb, xc, yc);
		g.drawLine(xc, yc, xa, ya);
	}

}
