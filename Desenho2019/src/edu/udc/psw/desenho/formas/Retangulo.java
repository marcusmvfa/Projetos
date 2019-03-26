package edu.udc.psw.desenho.formas;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorRetangulo;

public class Retangulo implements FormaGeometrica {
	private Ponto a = null;
	private Ponto b = null;
	
	public Retangulo(){
		a = new Ponto();
		b = new Ponto();
	}
	
	public Retangulo(Ponto a, Ponto b) throws CloneNotSupportedException{
		this.a = a.clone();
		this.b = b.clone();
	}
	
	public Retangulo(int ax, int ay, int bx, int by){
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
	
	public Ponto centro(){
		return new Ponto((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
	}
	
	public double base(){
		return Math.abs(a.getX() - b.getX());
	}
	
	public double altura(){
		return Math.abs(a.getY() - b.getY());
	}
	
	public double area(){
		return base() * altura();
	}

	@Override
	public double perimetro() {
		return 2 * base() + 2 * altura();
	}

	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorRetangulo(this);
	}

	@Override
	public Retangulo clone() {
		return new Retangulo();
	}
}
