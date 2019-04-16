package edu.udc.psw.desenho.formas;

import java.awt.Graphics;

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
	public Triangulo(Ponto a, Ponto b, Ponto c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Triangulo(int ax, int ay, int bx, int by, int cx, int cy) {
		a = new Ponto(ax,ay);
		b = new Ponto(bx,by);
		c = new Ponto(cx,cy);
	}
	
	public Ponto getA(){
		return a;
	}

	public void setA(Ponto a){
		this.a = a;
	}

	public Ponto getB(){
		return b;
	}

	public void setB(Ponto b){
		this.b = b;
	}

	public Ponto getC(){
		return c;
	}

	public void setC(Ponto c){
		this.c = c;
	}

	
	public Ponto centro() {
		return a;
		//return new Ponto2D((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);//Centro de Massa
	}

	
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public double base() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public double altura() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ManipuladorFormaGeometrica getManipulador() {
		// TODO Auto-generated method stub
		return new ManipuladorTriangulo(this);
	}

	@Override
	public FormaGeometrica clone() {
		// TODO Auto-generated method stub
		return new Triangulo();
	}
	@Override
	public void desenhar(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
