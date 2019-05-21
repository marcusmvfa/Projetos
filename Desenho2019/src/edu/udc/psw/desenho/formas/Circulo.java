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
		//g.drawOval(a.x, a.y, (int)Math.round(Raio()), (int)Math.round(Raio()));
		int xa = 0;
		try {
			xa = (int) getA().getX();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int xb = 0;
		try {
			xb = (int) getB().getX();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ya = 0;
		try {
			ya = (int) getA().getY();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int yb = 0;
		try {
			yb = (int) getB().getY();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawOval(xa < xb ? xa : xb, ya < yb ? ya : yb, 
				(int) altura() , (int) altura());
		
	}

	public static FormaGeometrica fabricar(String circulo) {
		if(!circulo.isEmpty()){
			int i = circulo.indexOf(' ');
			int x = Integer.parseInt(circulo.substring(0, i));
			circulo = circulo.substring(i + 1);
			i = circulo.indexOf(' ');
			int y = Integer.parseInt(circulo.substring(0, i));
			Ponto a = new Ponto(x, y);
			
			circulo = circulo.substring(i+1);
			i = circulo.indexOf(' ');
			x = Integer.parseInt(circulo.substring(0, i));
			y = Integer.parseInt(circulo.substring(i +1, circulo.length()));
//			double z = Double.parseDouble(circulo.substring(0, circulo.length()));
			
//			y = (int) z;
			Ponto b = new Ponto(x,y);
			
			return new Circulo(a, b);
		}
			
		return null;
	}

	@Override
	public byte[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
//		return String.format("%s %s",a, String.valueOf(Raio()));
		return String.format("%s %s",a, b);
	}

}
