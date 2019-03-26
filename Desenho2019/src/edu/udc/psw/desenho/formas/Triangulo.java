package edu.udc.psw.desenho.formas;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorTriangulo;

public class Triangulo implements FormaGeometrica{
	private Ponto a;
	private Ponto b;
	private Ponto c;
	
	public Triangulo() {
		a = new Ponto();
		b = new Ponto();
		c = new Ponto();
	}
	public Triangulo(Ponto a, Ponto b, Ponto c) throws CloneNotSupportedException {
		this.a = a.clone();
		this.b = b.clone();
		this.c = c.clone();
	}
	public Triangulo(int ax, int ay, int bx, int by, int cx, int cy) {
		a = new Ponto(ax,ay);
		b = new Ponto(bx,by);
		c = new Ponto(cx,cy);
	}
	
	public Ponto getA() throws CloneNotSupportedException {
		return a.clone();
	}

	public void setA(Ponto a) throws CloneNotSupportedException {
		this.a = a.clone();
	}

	public Ponto getB() throws CloneNotSupportedException {
		return b.clone();
	}

	public void setB(Ponto b) throws CloneNotSupportedException {
		this.b = b.clone();
	}

	public Ponto getC() throws CloneNotSupportedException {
		return c.clone();
	}

	public void setC(Ponto c) throws CloneNotSupportedException {
		this.c = c.clone();
	}

	@Override
	public Ponto centro() {
		return a;
		//return new Ponto2D((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);//Centro de Massa
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double base() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double altura() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		// TODO Auto-generated method stub
		return new ManipuladorTriangulo(this);
	}

	@Override
	public FormaGeometrica clone() {
		// TODO Auto-generated method stub
		return new Triangulo();
	}

}
