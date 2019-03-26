package edu.udc.psw.desenho.formas;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorCirculo;

public class Circulo implements FormaGeometrica{
	private Ponto a;
	private Ponto b;
	
	public Circulo() {
		a = new Ponto();
		b = new Ponto();
	}
	
	public Circulo(Ponto a, Ponto b) throws CloneNotSupportedException {
		this.a = a.clone();
		this.b = b.clone();
	}
	
	public Circulo(int ax, int ay, int bx, int by) {
		a = new Ponto(ax, ay);
		b = new Ponto(bx, by);
	}

	public Ponto getA() throws CloneNotSupportedException {
		return a.clone();
	}
	public Ponto getB() throws CloneNotSupportedException {
		return b.clone();
	}
	public void setA(Ponto a) throws CloneNotSupportedException {
		this.a = a.clone();
	}
	public void setB(Ponto b) throws CloneNotSupportedException {
		this.b = b.clone();
	}

	@Override
	public Ponto centro() {
		return new Ponto(a.getX(),a.getY());
	}

	@Override
	public double area() {
		return Math.PI * (Raio() * Raio());
	}
	@Override
	public double perimetro() {	
		return Math.PI * Raio();
	}

	@Override
	public double base() {	//DIAMETRO
		return 2 * Math.abs(a.getX() - b.getX());
	}

	@Override
	public double altura() {
		return Math.abs((a.getY() - b.getY()) + (a.getX() - b.getX()) /2);
	}
	public double Raio() {
		return Math.PI * base();
	}

	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorCirculo(this);
	}

	@Override
	public Circulo clone() {
		return new Circulo();
	}

}
