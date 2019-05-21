package edu.udc.psw.desenho.formas;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorTriangulo;

public class Triangulo implements FormaGeometrica{
	private Ponto a;
	private Ponto b;
	private Ponto c;
	private double meio;
	private double distB_C;
	
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
		return (a.getX() - b.getX());
	}

	
	public double altura() {
		meio = (base() / 2);
		distB_C = b.distancia(c);
		
		return Math.sqrt((meio * meio) + (distB_C * distB_C));
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
		
		int xa = 0;
		try {
			xa = (int) this.getA().getX();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int xb = 0;
		try {
			xb = (int) this.getB().getX();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int xc = 0;
		try {
			xc = (int) this.getC().getX();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ya = 0;
		try {
			ya = (int) this.getA().getY();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int yb = 0;
		try {
			yb = (int) this.getB().getY();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int yc = 0;
		try {
			yc = (int) this.getC().getY();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawLine(xa, ya, xb, yb);
		g.drawLine(xb, yb, xc, yc);
		g.drawLine(xc, yc, xa, ya);
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
	
	public String toString(){
		return String.format("%s %s %s", a, b, c);
	}

}
