package edu.udc.psw.desenho.formas.manipulador;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.Circulo;
import edu.udc.psw.desenho.formas.Ponto;

public class ManipuladorCirculo implements ManipuladorFormaGeometrica {
	private Circulo circulo;
	
	public ManipuladorCirculo(Circulo c) {
		circulo = c;
		System.out.println("Circulo Instanciado!");
	}
	
	@Override
	public void click(int x, int y) {
	}

	@Override
	public void press(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			circulo.setA(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ponto A: " + p);
		p = new Ponto(x, y);
		try {
			circulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void release(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			circulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void drag(int x, int y) {
		Ponto p = new Ponto(x, y);
		try {
			circulo.setB(p);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Arrastou");
	}

	@Override
	public void paint(Graphics g) {
		int xa = 0;
		try {
			xa = (int) circulo.getA().getX();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int xb = 0;
		try {
			xb = (int) circulo.getB().getX();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ya = 0;
		try {
			ya = (int) circulo.getA().getY();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int yb = 0;
		try {
			yb = (int) circulo.getB().getY();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawOval(xa < xb ? xa : xb, ya < yb ? ya : yb, 
				(int) circulo.altura() , (int) circulo.altura());
	}

}
