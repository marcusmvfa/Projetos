package edu.udc.psw.desenho.formas;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorCirculo;

public class Circulo implements FormaGeometrica{
	private Ponto a;
	private Ponto b;
	
	public Circulo() {
		a = new Ponto();
		b = new Ponto();
	}
	
	public Circulo(Ponto a, Ponto b){
		this.a = a;
		this.b = b;
	}
	
	public Circulo(int ax, int ay, int bx, int by) {
		a = new Ponto(ax, ay);
		b = new Ponto(bx, by);
	}

	public Ponto getA(){
		return a;
	}
	public Ponto getB(){
		return b;
	}
	public void setA(Ponto a){
		this.a = a;
	}
	public void setB(Ponto b){
		this.b = b;
	}

	
	public Ponto centro() {
		return new Ponto(a.getX(),a.getY());
	}

	
	public double area() {
		return Math.PI * (Raio() * Raio());
	}
	
	public double perimetro() {	
		return Math.PI * Raio();
	}

	
	public double base() {	//DIAMETRO
		return 2 * Math.abs(a.getX() - b.getX());
	}


	public double altura() {
		return Math.abs((a.getY() - b.getY()) + (a.getX() - b.getX()) /2);
	}
	public double Raio() {
		return Math.PI * base();
	}

	
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorCirculo(this);
	}

	@Override
	public Circulo clone() {
		return new Circulo();
	}

	@Override
	public void desenhar(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}