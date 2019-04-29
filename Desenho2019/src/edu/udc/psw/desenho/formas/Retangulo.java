package edu.udc.psw.desenho.formas;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorRetangulo;

public class Retangulo implements FormaGeometrica {
	private Ponto a = null;
	private Ponto b = null;
	
	public Retangulo(){
		a = new Ponto();
		b = new Ponto();
	}
	
	public Retangulo(Ponto a, Ponto b){
		this.a = a;
		this.b = b;
	}
	
	public Retangulo(int ax, int ay, int bx, int by){
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

	
	public double perimetro() {
		return 2 * base() + 2 * altura();
	}

	
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorRetangulo(this);
	}


	public Retangulo clone() {
		return new Retangulo();
	}

	@Override
	public void desenhar(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	public FormaGeometrica fabricar(String forma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
