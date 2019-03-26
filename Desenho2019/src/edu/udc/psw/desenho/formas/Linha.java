package edu.udc.psw.desenho.formas;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorLinha;
import edu.udc.psw.desenho.formas.Ponto;

public class Linha implements FormaGeometrica {
	private Ponto a = null;
	private Ponto b = null;
	
	public Linha(){
		a = new Ponto();
		b = new Ponto();
	}

	public Linha(Ponto a, Ponto b) throws CloneNotSupportedException{
		this.a = a.clone();
		this.b = b.clone();
	}
	
	public Linha(int ax, int ay, int bx, int by){
		a = new Ponto(ax, ay);
		b = new Ponto(bx, by);
	}
	
	
	@Override
	public Linha clone() {
		return new Linha();
	}

	public double comprimento(){
		return a.distancia(b);
	}
	
	@Override
	public Ponto centro(){
		Ponto m = new Ponto((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
		return m;
	}
	
	@Override
	public double base(){
		if(a.getX() < b.getX())
			return b.getX() - a.getX();
		return a.getX() - b.getX();
	}
	
	@Override
	public double altura(){
		if(a.getY() < b.getY())
			return b.getY() - a.getY();
		return a.getY() - b.getY();
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
	public String toString(){
		return a.toString() + b.toString();
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimetro() {
		return comprimento();
	}

	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorLinha(this);
	}

}
